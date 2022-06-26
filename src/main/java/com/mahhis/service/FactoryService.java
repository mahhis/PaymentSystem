package com.mahhis.service;

import com.mahhis.service.impl.CardServiceImpl;
import com.mahhis.service.impl.OrderServiceImpl;
import com.mahhis.service.impl.TransactionServiceImpl;
import com.mahhis.service.impl.UserServiceImpl;

public final class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private final UserService userService = new UserServiceImpl();
    private final CardService cardService = new CardServiceImpl();
    private final TransactionService transactionService = new TransactionServiceImpl();
    private final OrderService orderService = new OrderServiceImpl();


    private FactoryService(){}

    public static FactoryService getInstance(){
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }
    public CardService getCardService(){return cardService;}
    public TransactionService getTransactionService(){return transactionService;}
    public OrderService getOrderService(){return orderService;}
}
