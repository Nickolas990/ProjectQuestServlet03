package com.javarush.echo.nikolaymelnikov.projectservletquest_03;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.mapcreator.DefaultMapCreator;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("gameMap", DefaultMapCreator.create());
        ctx.setAttribute("userRepository", new UserRepository());
        }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
