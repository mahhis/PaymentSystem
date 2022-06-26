package com.mahhis.controller;

import com.mahhis.controller.impl.*;
import com.mahhis.controller.impl.goToCommands.GoToMainPage;
import com.mahhis.controller.impl.goToCommands.GoToSignInPage;
import com.mahhis.controller.impl.goToCommands.GoToSignUpPage;
import com.mahhis.controller.impl.goToCommands.GoToTransactionListPage;

import java.util.HashMap;
import java.util.Map;

public final class CommandProvider {
	private final Map<String, Command> commands = new HashMap<String, Command>(); 
	
	public CommandProvider() {
		commands.put("SignIn", new SignInCommand());
		commands.put("SignUp", new SignUpCommand());
		commands.put("AddCard", new AddCardCommand());
		commands.put("Transaction", new TransactionCommand());
		commands.put("ChangeLocal", new ChangeLocalCommand());

		commands.put("GoToSignUpPage", new GoToSignUpPage());
		commands.put("GoToTransactionListPage", new GoToTransactionListPage());
		commands.put("GoToSignInPage", new GoToSignInPage());
		commands.put("GoToMainPage", new GoToMainPage());
	}
	
	public final Command getCommand(String commandName) {
		Command command = commands.get(commandName);
		return command;
	}
}
