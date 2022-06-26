package com.mahhis.dao;

import com.mahhis.dao.impl.CardDAOImpl;
import com.mahhis.dao.impl.OrderDAOImpl;
import com.mahhis.dao.impl.TransactionDAOImpl;
import com.mahhis.dao.impl.UserDAOImpl;

public class FactoryDAO {

    private final static FactoryDAO instance = new FactoryDAO();

    private final CardDAO cardDAO = new CardDAOImpl();
    private final TransactionDAO transactionDAO = new TransactionDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();
    private final OrderDAO orderDAO = new OrderDAOImpl();

    private FactoryDAO(){

    }

    public static FactoryDAO getInstance(){

        return instance;
    }

    public CardDAO getCardDAO(){
        return cardDAO;
    }

    public TransactionDAO getTransactionDAO(){
        return transactionDAO;
    }
    public UserDAO getUserDAO(){
        return userDAO;
    }
    public OrderDAO getOrderDAO(){
        return orderDAO;
    }





}
