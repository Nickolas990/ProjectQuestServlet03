package com.javarush.echo.nikolaymelnikov.projectservletquest_03.servlets;

import com.javarush.echo.nikolaymelnikov.projectservletquest_03.GameMap;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.User;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.UserRepository;
import com.javarush.echo.nikolaymelnikov.projectservletquest_03.characters.Hero;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RegistrationServletTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private GameMap gameMap;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private HttpSession session;
    @Mock
    private ServletContext servletContext;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private User user;
    @Mock
    private Hero hero;
    @Spy
    private RegistrationServlet registrationServlet;

    @Test
    void test_init() throws ServletException {
        when(servletConfig.getServletContext())
                .thenReturn(servletContext);
        when(servletContext.getAttribute(argThat(("userRepository"::equals))))
                .thenReturn(userRepository);
        when(servletContext.getAttribute(argThat(("gameMap"::equals))))
                .thenReturn(gameMap);

        registrationServlet.init(servletConfig);

        verify(servletConfig).getServletContext();
        verify(servletContext).getAttribute("userRepository");
        verify(servletContext).getAttribute("gameMap");

    }

    @Test
    void test_doPost_if_user_is_new() throws ServletException {
        when(request.getParameter(argThat("username"::equals)))
                .thenReturn("MockUser");
        when(request.getSession())
                .thenReturn(session);
        when(servletConfig.getServletContext())
                .thenReturn(servletContext);
        when(servletContext.getAttribute(argThat(("userRepository"::equals))))
                .thenReturn(userRepository);
        when(servletContext.getAttribute(argThat(("gameMap"::equals))))
                .thenReturn(gameMap);
        when(userRepository.isExist("MockUser"))
                .thenReturn(false);
        when(userRepository.load("MockUser"))
                .thenReturn(user);
        when(user.getHero())
                .thenReturn(hero);

        registrationServlet.init(servletConfig);
        registrationServlet.doPost(request, response);

        verify(userRepository).load("MockUser");
    }

    @Test
    void test_doPost_if_user_is_not_new() throws ServletException {
        when(request.getParameter(argThat("username"::equals)))
                .thenReturn("MockUser");
        when(request.getSession())
                .thenReturn(session);
        when(servletConfig.getServletContext())
                .thenReturn(servletContext);
        when(servletContext.getAttribute(argThat(("userRepository"::equals))))
                .thenReturn(userRepository);
        when(servletContext.getAttribute(argThat(("gameMap"::equals))))
                .thenReturn(gameMap);
        when(userRepository.isExist("MockUser"))
                .thenReturn(true);
        when(userRepository.load("MockUser"))
                .thenReturn(user);
        when(user.getHero())
                .thenReturn(hero);

        registrationServlet.init(servletConfig);
        registrationServlet.doPost(request, response);

        verify(userRepository).load("MockUser");
    }
}
