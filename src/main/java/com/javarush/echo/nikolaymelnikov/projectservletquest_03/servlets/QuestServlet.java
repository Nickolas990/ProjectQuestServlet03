package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.QuestGiver;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.dialog.Dialogue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "QuestServlet", value = "/quest")
public class QuestServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(QuestServlet.class);

    public static final String CHARACTER = "character";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        HttpSession currentSession = request.getSession();
        Hero hero = (Hero) currentSession.getAttribute("hero");
        Location currentLocation = (Location) currentSession.getAttribute("location");
        QuestGiver questGiver = (QuestGiver) currentLocation.getNPCInLocation()
                .stream()
                .filter(e -> e.getName().equals(request.getParameter(CHARACTER)))
                .findFirst()
                .orElse((QuestGiver) currentSession.getAttribute(CHARACTER));
        Dialogue dialogue = questGiver.getDialog();
        String id = Objects.isNull(request.getParameter("id")) ? "start" : request.getParameter("id");
        if ("end".equals(id)) {
            return;
        }

        if ("getQuest".equals(id)) {
            hero.setCurrentQuest(questGiver.getQuest());
            return;
        }

        currentSession.setAttribute("question", dialogue.getBlockById(id).getQuestion());
        currentSession.setAttribute("answers", dialogue.getBlockById(id).getAnswers());
        currentSession.setAttribute("dialogue", dialogue);
        currentSession.setAttribute(CHARACTER, questGiver);
        try {
            response.sendRedirect(request.getContextPath() +"/Quest.jsp");
        } catch (IOException e) {
            logger.error("{} while redirecting to Game.jsp", e.getMessage());
        }

    }
}
