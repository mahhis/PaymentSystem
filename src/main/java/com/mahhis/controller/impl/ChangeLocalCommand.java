package com.mahhis.controller.impl;

import com.mahhis.controller.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ChangeLocalCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       request.getSession(true).setAttribute("local", request.getParameter("local"));
       request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
