package com.epam.mahhis.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.mahhis.controller.impl.GoToSignInPage;
import com.epam.mahhis.controller.impl.GoToSignUpPage;
import com.epam.mahhis.controller.impl.SignInCommand;
import com.epam.mahhis.controller.impl.SignUpCommand;

public final class CommandProvider {
	private final Map<String, Command> commands = new HashMap<String, Command>(); 
	
	public CommandProvider() {
		commands.put("SignIn", new SignInCommand());
		commands.put("SignUp", new SignUpCommand());

		commands.put("GoToSignUpPage", new GoToSignUpPage());
		commands.put("GoToSignInPage", new GoToSignInPage());
	}
	
	public final Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}
}
