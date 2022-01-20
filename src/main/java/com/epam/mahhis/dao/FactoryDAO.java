package com.epam.mahhis.dao;

import com.epam.mahhis.dao.impl.AccountDAOImpl;
import com.epam.mahhis.dao.impl.TransactionDAOImpl;
import com.epam.mahhis.dao.impl.UserDAOImpl;

public class FactoryDAO {

    private final static FactoryDAO instance = new FactoryDAO();

    private final AccountDAO accountDAO = new AccountDAOImpl();
    private final TransactionDAO transactionDAO = new TransactionDAOImpl();
    private final UserDAO userDAO = new UserDAOImpl();

    private FactoryDAO(){}

    public static FactoryDAO getInstance(){
        return instance;
    }

    public AccountDAO getAccountDAO(){
        return accountDAO;
    }

    public TransactionDAO getTransactionDAO(){
        return transactionDAO;
    }
    public UserDAO getUserDAO(){
        return userDAO;
    }





}
