package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.User;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.mapcreator.DefaultMapCreator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {
    private static Logger log = LoggerFactory.getLogger(GameServlet.class);

    private Hero hero;
    private User user;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        user = (User) session.getAttribute("user");
        hero = user.getHero();

        HttpSession currentSession = request.getSession();
        currentSession.setAttribute("location", hero.getCurrentLocation());
        currentSession.setAttribute("hero", hero);
        response.sendRedirect("Game.jsp");
    }

    public void destroy() {
    }
}