package com.mahhis.controller.impl.goToCommands;

import com.mahhis.controller.Command;
import com.mahhis.controller.constants.CommandName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToMainPage implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        response.sendRedirect(CommandName.MAIN_PAGE);
       /* RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.MAIN_PAGE);
        dispatcher.forward(request, response);*/

    }
}
