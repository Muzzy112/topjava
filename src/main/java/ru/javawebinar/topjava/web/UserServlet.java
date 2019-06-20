package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepositoryImpl;
import ru.javawebinar.topjava.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class UserServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

    UserServiceImpl usi = new UserServiceImpl(new InMemoryUserRepositoryImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("forward to users");
        List<String> uu = usi.getAll().stream().map(User::getName).collect(Collectors.toList());
        uu.forEach(u -> System.out.println("::: " + u));
        request.setAttribute("users", uu);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
