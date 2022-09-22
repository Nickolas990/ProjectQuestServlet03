package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.QuestGiver;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Answer;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Block;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Dialogue;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.quests.Quest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuestServletTest {

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletContext servletContext;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private Hero hero;
    @Mock
    private QuestGiver questGiver;
    @Mock
    private Dialogue dialogue;
    @Mock
    private Location location;
    @Mock
    private Block block;
    @Mock
    private Quest quest;
    @Spy
    private QuestServlet questServlet;

    @Test
    void test_doGet_end_dialog() throws ServletException, IOException {
        when(request.getSession())
                .thenReturn(session);
        when(session.getAttribute(argThat("hero"::equals)))
                .thenReturn(hero);
        when(session.getAttribute(argThat("location"::equals)))
                .thenReturn(location);
        when(session.getAttribute(argThat("character"::equals)))
                .thenReturn(questGiver);
        when(questGiver.getDialog())
                .thenReturn(dialogue);
        when(request.getParameter(argThat("id"::equals)))
                .thenReturn("end");
        questServlet.doGet(request, response);

    }

    @Test
    void test_doGet_start_dialog() throws ServletException, IOException {
        Answer[] mockAnswersArray = new Answer[1];

        when(request.getSession())
                .thenReturn(session);
        when(session.getAttribute(argThat("hero"::equals)))
                .thenReturn(hero);
        when(session.getAttribute(argThat("location"::equals)))
                .thenReturn(location);
        when(session.getAttribute(argThat("character"::equals)))
                .thenReturn(questGiver);
        when(questGiver.getDialog())
                .thenReturn(dialogue);
        when(request.getParameter(argThat("id"::equals)))
                .thenReturn(null);
        when(dialogue.getBlockById("start"))
                .thenReturn(block);
        when(block.getQuestion())
                .thenReturn("mockQuestion");
        when(block.getAnswers())
                .thenReturn(mockAnswersArray);
        when(request.getContextPath()).thenReturn("/mock");

        questServlet.doGet(request, response);

        verify(session).setAttribute("question", "mockQuestion");
        verify(session).setAttribute("answers", mockAnswersArray);
        verify(session).setAttribute("dialogue", dialogue);
        verify(session).setAttribute("character", questGiver);
        verify(response).sendRedirect("/mock/Quest.jsp");
    }

    @Test
    void test_doGet_get_quest_dialog() throws ServletException, IOException {
        Answer[] mockAnswersArray = new Answer[1];

        when(request.getSession())
                .thenReturn(session);
        when(session.getAttribute(argThat("hero"::equals)))
                .thenReturn(hero);
        when(session.getAttribute(argThat("location"::equals)))
                .thenReturn(location);
        when(session.getAttribute(argThat("character"::equals)))
                .thenReturn(questGiver);
        when(questGiver.getQuest())
                .thenReturn(quest);
        when(request.getParameter(argThat("id"::equals)))
                .thenReturn("getQuest");

        questServlet.doGet(request, response);

        verify(hero).setCurrentQuest(quest);
    }

}