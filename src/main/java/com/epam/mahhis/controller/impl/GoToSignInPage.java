package com.epam.mahhis.controller.impl;

import com.epam.mahhis.controller.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToSignInPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("logggin");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signIn.jsp");
        dispatcher.forward(request, response);
    }
}
