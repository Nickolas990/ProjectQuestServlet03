package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.Location;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.UserRepository;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Move", value = "/move")
public class MoveServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        GameMap gameMap = (GameMap) session.getAttribute("gameMap");
        Location destination = gameMap.getMap().get(request.getParameter("destination"));
        Hero hero = (Hero) session.getAttribute("hero");

        hero.move(destination);
        System.out.println(hero.getCurrentLocation());
        session.setAttribute("hero", hero);
        response.sendRedirect("game");



    }
}
