package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.mapcreator.DefaultMapCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/game-servlet")
public class GameServlet extends HttpServlet {
    private String message;
    private Hero hero;
    private static Logger log = LoggerFactory.getLogger(GameServlet.class);
    private GameMap gameMap;

    public void init() {
        gameMap = DefaultMapCreator.create();
        hero = new Hero(gameMap);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("location", hero.getCurrentLocation());
        currentSession.setAttribute("hero", hero);
        response.sendRedirect("Game.jsp");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}