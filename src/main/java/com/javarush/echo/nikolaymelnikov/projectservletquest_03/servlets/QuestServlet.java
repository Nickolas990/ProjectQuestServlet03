package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.QuestGiver;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Dialogue;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    private QuestGiver questGiver;
    private Dialogue dialogue;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession currentSession = request.getSession();
        Hero hero = (Hero) currentSession.getAttribute("hero");
        Location currentLocation = (Location) currentSession.getAttribute("location");
        questGiver = (QuestGiver) currentLocation.getCharacterInLocation()
                .stream()
                .filter(e -> e.getName().equals(request.getParameter("character")))
                .findFirst()
                .orElse((QuestGiver)currentSession.getAttribute("character"));
        dialogue = questGiver.getDialog();
        System.out.println(questGiver);
        String id = request.getParameter("id");
        if ("end".equals(id)) {
            //response.sendRedirect("/Game.jsp");
            return;
        }
        if (id == null) {
            id = "start";
        }

        if ("getQuest".equals(id)) {
            hero.setCurrentQuest(questGiver.getQuest());
        }

        currentSession.setAttribute("question", dialogue.getBlockById(id).getQuestion());
        currentSession.setAttribute("answers", dialogue.getBlockById(id).getAnswers());
        currentSession.setAttribute("dialogue", dialogue);
        currentSession.setAttribute("character", questGiver);
        response.sendRedirect("/Quest.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }
}
