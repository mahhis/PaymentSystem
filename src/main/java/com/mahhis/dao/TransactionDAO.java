package com.mahhis.dao;

import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.transaction.Transaction;

import java.util.List;

public interface TransactionDAO {


    Transaction findById(int userId) throws DAOException;
    List<Transaction> findByAmount(double amountMoney) throws DAOException;
    void createTransaction(Transaction transaction) throws DAOException;
    void deleteTransaction(Transaction transaction) throws DAOException;

}
