package com.mahhis.dao.builder;

import com.mahhis.entity.transaction.Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionBuilder {

    public Transaction buildTransaction(ResultSet resultSet) throws SQLException{
        Transaction transaction = new Transaction();
        build(transaction, resultSet);
        return transaction;
        
    }



    private void build(Transaction transaction, ResultSet resultSet) throws SQLException{

        transaction.setIdTransaction(resultSet.getInt("idTransaction"));
        transaction.setCardNumberGetter(resultSet.getLong("cardNumberSender"));
        transaction.setCardValidityDate(resultSet.getString("cardValidityDate"));
        transaction.setCVV(resultSet.getShort("CVV"));
        transaction.setSum(resultSet.getDouble("sum"));
        transaction.setBankNameSender(resultSet.getString("bankNameSender"));
        transaction.setSenderCountry(resultSet.getString("senderCountry"));

        transaction.setCardNumberGetter(resultSet.getLong("cardNumberGetter"));
        transaction.setBankNameGetter(resultSet.getString("bankNameGetter"));
        transaction.setGetterCountry(resultSet.getString("getterCountry"));

    }
}
