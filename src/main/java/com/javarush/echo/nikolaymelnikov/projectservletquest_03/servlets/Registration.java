package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.User;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.UserRepository;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class Registration extends HttpServlet {

    private UserRepository userRepository = null;
    private GameMap gameMap = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
        gameMap = (GameMap) servletContext.getAttribute("gameMap");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        System.out.println(username);
        User user = userRepository.load(username);
        if (user.getHero() == null) {
            user.setHero(new Hero(gameMap));
            user.getHero().setName(user.getUsername());
        }

        session.setAttribute("user", user);
        session.setAttribute("hero", user.getHero());
        session.setAttribute("gameMap", gameMap);
        response.sendRedirect("game");

    }
}
