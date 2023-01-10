package com.mahhis.controller.impl.goToCommands;

import com.mahhis.controller.Command;
import com.mahhis.controller.constants.PagePath;
import com.mahhis.controller.constants.ParameterName;
import com.mahhis.entity.order.Order;
import com.mahhis.entity.user.User;
import com.mahhis.service.FactoryService;
import com.mahhis.service.OrderService;
import com.mahhis.service.UserService;
import com.mahhis.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoToTransactionListPage implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(PagePath.TRANSACTION_LIST_PAGE);
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute(ParameterName.LOGIN);

        UserService userService = FactoryService.getInstance().getUserService();
        OrderService orderService = FactoryService.getInstance().getOrderService();

        User user;
        List<Order> userOrders = new ArrayList<>();
        System.out.println(session.getAttribute(ParameterName.LOGIN));
        System.out.println(session.getId());
        try {
            user = userService.findByLogin(login);
            userOrders = orderService.findAllFromUser(user);

            session.setAttribute(ParameterName.ORDERS, userOrders);
            dispatcher.forward(request, response);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
