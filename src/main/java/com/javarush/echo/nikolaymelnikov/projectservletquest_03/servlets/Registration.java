package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.User;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.UserRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class Registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        UserRepository userRepo = (UserRepository) request.getAttribute("userRepo");
        System.out.println(username);
        User user = userRepo.load(username);

        request.setAttribute("user", user);
        getServletContext()
                .getRequestDispatcher("/Game.jsp")
                .forward(request, response);

    }
}
