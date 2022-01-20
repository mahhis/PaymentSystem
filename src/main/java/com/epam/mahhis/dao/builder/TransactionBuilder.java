package com.epam.mahhis.dao.builder;

import com.epam.mahhis.entity.transaction.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionBuilder {

    public Transaction buildTransaction(ResultSet resultSet) throws SQLException{
        Transaction transaction = new Transaction();
        build(transaction, resultSet);
        return transaction;
        
    }



    private void build(Transaction transaction, ResultSet resultSet) throws SQLException{
    	transaction.setComment(resultSet.getString("comment"));
    	transaction.setIdTransaction(resultSet.getInt("idTransaction"));
    	transaction.setTime(resultSet.getDate("time"));
    	transaction.setTransactionAmount(resultSet.getDouble("transactionAmount"));
    	transaction.setTypePaymentSystem(resultSet.getString("typePaymentSystem"));
    	transaction.setCommissionPercentage(resultSet.getDouble("commissionPercentage"));
    	transaction.setTargetIdBankAccount(resultSet.getInt("targetIdBankAccount"));
    	transaction.setSenderIdBankAccount(resultSet.getInt("sederIdBankAccount"));

    }
}
