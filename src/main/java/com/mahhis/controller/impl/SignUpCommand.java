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
import java.io.IOException;
import java.util.List;

public class SignUpCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("SU1");
		String login = request.getParameter(ParameterName.LOGIN);
		String email = request.getParameter(ParameterName.EMAIL);
		String password = request.getParameter(ParameterName.PASSWORD);

		User user = new User();
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);
		System.out.println("SU2");

		UserService userService = FactoryService.getInstance().getUserService();
		CardService cardService = FactoryService.getInstance().getCardService();

		try {
			System.out.println("SU3");
			userService.registration(user);
			List<Card> userCards;
			userCards = cardService.findAll(user);
			System.out.println("SU4");

			request.getSession().setAttribute(ParameterName.LOGIN, user.getLogin());
			System.out.println("SU5");
			request.setAttribute(ParameterName.CARDS, userCards);
			System.out.println("SU6");
			System.out.println(CommandName.SIGN_IN_PAGE);
			response.sendRedirect(CommandName.SIGN_IN_PAGE);
			System.out.println("SU7");
		} catch (ServiceException e) {
			e.printStackTrace();
		}

	}

}
