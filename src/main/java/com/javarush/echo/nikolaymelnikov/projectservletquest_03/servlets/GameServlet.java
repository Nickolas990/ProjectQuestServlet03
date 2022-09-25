package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;


import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(GameServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession currentSession = request.getSession();
        Hero hero = (Hero) currentSession.getAttribute("hero");

        currentSession.setAttribute("location", hero.getCurrentLocation());
        currentSession.setAttribute("hero", hero);
        log.info("{} entered", hero.getName());
        response.sendRedirect("Game.jsp");
    }
}