package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.items.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "InventoryServlet", value = "/inventory")
public class InventoryServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(InventoryServlet.class);
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Hero hero = (Hero) session.getAttribute("hero");
        Optional<Item> result = hero.getCurrentLocation()
                .getItemsInLocation()
                .stream()
                .filter(loot -> loot.getName()
                        .equals(request.getParameter("item")))
                .findFirst();
        result.ifPresent(hero::take);
        try {
            response.sendRedirect("Game.jsp");
        } catch (IOException e) {
            logger.error("{} while redirecting to Game.jsp", e.getMessage());
        }
    }
}
