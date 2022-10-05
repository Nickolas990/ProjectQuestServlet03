package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.User;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.UserRepository;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "registration", value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationServlet.class);

    private UserRepository userRepository;
    private GameMap gameMap;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userRepository = (UserRepository) servletContext.getAttribute("userRepository");
        gameMap = (GameMap) servletContext.getAttribute("gameMap");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        User user;
        if (!userRepository.isExist(username)) {
            createUser(username);
        }

        user = userRepository.load(username);
        session.setAttribute("user", user);
        session.setAttribute("hero", user.getHero());
        session.setAttribute("gameMap", gameMap);
        try {
            response.sendRedirect("game");
        } catch (IOException e) {
            logger.error("{} while redirecting to game servlet", e.getMessage());
        }

    }

    private void createUser(String username) {
        User user = new User(username);
        userRepository.save(user);
        user.setHero(new Hero(gameMap));
        user.getHero().setName(user.getUsername());
    }
}
