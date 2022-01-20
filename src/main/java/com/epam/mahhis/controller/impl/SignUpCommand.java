package com.epam.mahhis.controller.impl;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.mahhis.controller.Command;

public class SignUpCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	System.out.println("RXXX");
		
		String login;
		String email;
		String password;
		
		login = request.getParameter("login");
		email = request.getParameter("email");
		password = request.getParameter("password");
		
		
		System.out.println(login + " - " + email + " - " + password );

		boolean flag = true;

		if(flag){
			request.setAttribute("registrationInf", "Error nepolnogo proekta");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ErrorPage.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		String string = "RJFS";
	    
		
	}

}
