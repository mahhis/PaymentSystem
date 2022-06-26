package com.mahhis.controller.impl.goToCommands;

import com.mahhis.controller.Command;
import com.mahhis.controller.constants.PagePath;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToTransactionListPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.TRANSACTION_LIST_PAGE);
        dispatcher.forward(request, response);
    }
}
