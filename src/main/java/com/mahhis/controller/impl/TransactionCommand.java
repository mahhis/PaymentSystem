package com.mahhis.controller.impl;

import com.mahhis.controller.Command;
import com.mahhis.controller.constants.CommandName;
import com.mahhis.controller.constants.ParameterName;
import com.mahhis.entity.order.Order;
import com.mahhis.entity.transaction.Transaction;
import com.mahhis.entity.user.User;
import com.mahhis.service.FactoryService;
import com.mahhis.service.OrderService;
import com.mahhis.service.TransactionService;
import com.mahhis.service.UserService;
import com.mahhis.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        long numberCardSender = Long.parseLong(request.getParameter(ParameterName.NUMBER_CARD_SENDER));
        String cardValidityDate = request.getParameter(ParameterName.CARD_VALIDITY_DATE);
        short CVV = Short.parseShort(request.getParameter(ParameterName.CVV));
        double sum = Double.parseDouble(request.getParameter(ParameterName.SUM));
        long numberCardGetter = Long.parseLong(request.getParameter(ParameterName.NUMBER_CARD_GETTER));

        String bankNameSender = request.getParameter("bankNameSender");
        String senderCountry = request.getParameter("senderCountry");

        String bankNameGetter = request.getParameter("bankNameGetter");
        String getterCountry = request.getParameter("getterCountry");

        /*System.out.println("numberCardSender : "+numberCardSender);
        System.out.println("cardValidityDate : "+cardValidityDate);
        System.out.println("CVV : "+CVV);
        System.out.println("sum : "+sum);
        System.out.println("numberCardGetter : "+numberCardGetter);
        System.out.println("bankNameSender : "+bankNameSender);
        System.out.println("senderCountry : "+senderCountry);
        System.out.println("bankNameGetter : "+bankNameGetter);
        System.out.println("getterCountry : "+getterCountry);
        String bankNameSender = Parser.information(numberCardSender, "issuer","name");
        String senderCountry = Parser.information(numberCardSender, "country","name");
        String bankNameGetter = Parser.information(numberCardSender, "issuer","name");
        String getterCountry = Parser.information(numberCardSender, "country","name");*/


        HttpSession session = request.getSession();
        String login = (String) session.getAttribute(ParameterName.LOGIN);

        Transaction transaction = new Transaction();

        transaction.setCardNumberSender(numberCardSender);
        transaction.setCardValidityDate(cardValidityDate);
        transaction.setCVV(CVV);
        transaction.setSum(sum);
        transaction.setBankNameSender(bankNameSender);
        transaction.setSenderCountry(senderCountry);

        transaction.setCardNumberGetter(numberCardGetter);
        transaction.setBankNameGetter(bankNameGetter);
        transaction.setGetterCountry(getterCountry);

        User user;
        UserService userService = FactoryService.getInstance().getUserService();
        TransactionService transactionService = FactoryService.getInstance().getTransactionService();
        OrderService orderService = FactoryService.getInstance().getOrderService();


        try {
            user = userService.findByLogin(login);
            transactionService.choiceDirectTranslationAndTransfer(transaction);
            transactionService.registerOrder(user, numberCardGetter, sum, bankNameGetter, getterCountry);

            List<Order> userOrders = new ArrayList<>();
            user = userService.findByLogin(login);
            userOrders = orderService.findAllFromUser(user);

            session.setAttribute(ParameterName.ORDERS, userOrders);

            response.sendRedirect(CommandName.TRANSACTION_LIST_PAGE);

        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
