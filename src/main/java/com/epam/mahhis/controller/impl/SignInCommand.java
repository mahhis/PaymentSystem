package com.epam.mahhis.controller.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.mahhis.controller.Command;
import com.epam.mahhis.service.FactoryService;
import com.epam.mahhis.service.UserService;

public class SignInCommand implements Command{


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
		System.out.println("LXXX");
		
		String login;
		String password;
		
		login = request.getParameter("login");
		password = request.getParameter("password");

		FactoryService serviceFactory = FactoryService.getInstance();
		UserService userService = serviceFactory.getUserService();
		String role = userService.authorisation(login, password);

		HttpSession session = request.getSession(true);
		if(!"".equals(role)){
			session.setAttribute("role", role);
			request.setAttribute("login", login);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			requestDispatcher.forward(request, response);
		}
		else {

		}
		
		System.out.println(login + " - " + password);
		
		
		PrintWriter out = response.getWriter();
		String string = "LJFS";
	    out.print("<h1> Hello,"+string+"</h1>");
		
	}

}
