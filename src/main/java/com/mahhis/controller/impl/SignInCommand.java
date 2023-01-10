package com.mahhis.controller.impl;

import com.mahhis.controller.Command;
import com.mahhis.controller.constants.CommandName;
import com.mahhis.controller.constants.ParameterName;
import com.mahhis.entity.card.Card;
import com.mahhis.entity.user.User;
import com.mahhis.service.CardService;
import com.mahhis.service.FactoryService;
import com.mahhis.service.UserService;
import com.mahhis.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignInCommand implements Command {


	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String login = request.getParameter(ParameterName.LOGIN);
		String password = request.getParameter(ParameterName.PASSWORD);
		HttpSession session = request.getSession();
		User user;

		UserService userService = FactoryService.getInstance().getUserService();
		CardService cardService = FactoryService.getInstance().getCardService();
		System.out.println(session.getId());

		try {
			if(userService.authorisation(login, password)){

				List<Card> userCards = new ArrayList<>();
				user = userService.findByLogin(login);
				userCards = cardService.findAll(user);


				session.setAttribute(ParameterName.CARDS, userCards);
				session.setAttribute(ParameterName.LOGIN, user.getLogin());

				response.sendRedirect(CommandName.MAIN_PAGE);
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

