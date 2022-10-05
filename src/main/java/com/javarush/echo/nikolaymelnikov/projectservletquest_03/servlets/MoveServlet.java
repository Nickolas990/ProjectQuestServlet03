package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Move", value = "/move")
public class MoveServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(MoveServlet.class);


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        GameMap gameMap = (GameMap) session.getAttribute("gameMap");
        Location destination = gameMap.getMap().get(request.getParameter("destination"));
        Hero hero = (Hero) session.getAttribute("hero");

        hero.move(destination);
        session.setAttribute("hero", hero);
        try {
            response.sendRedirect("game");
        } catch (IOException e) {
            logger.error("{} while redirecting to Game.jsp", e.getMessage());
        }

    }
}
