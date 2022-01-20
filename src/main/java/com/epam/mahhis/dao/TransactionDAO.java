package com.epam.mahhis.dao;

import com.epam.mahhis.entity.transaction.Transaction;
import com.epam.mahhis.entity.user.User;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface TransactionDAO {


    Transaction findById(int userId) throws SQLException;
    List<Transaction> findByAmount(double amountMoney);
    List<Transaction> findByDate(Date fromTime, Date toTime);

    void createTransaction(Transaction transaction);

}
