package com.epam.mahhis.dao.builder;

import com.epam.mahhis.entity.account.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountBuilder {
    public Account buildAccount(ResultSet resultSet) throws SQLException {
        Account account = new Account();
        build(account, resultSet);
        return account;
    }

    private void build(Account account, ResultSet resultSet) throws SQLException {
        account.setIdAccount(resultSet.getInt("idBankAccount"));
        account.setNumberAccount(resultSet.getString("numberBankAccount"));
        account.setIdUser(resultSet.getInt("idUsers"));
        account.setCurrency(resultSet.getString("currency"));
        account.setCountValue(resultSet.getLong("countValue"));
        account.setInterestRate(resultSet.getFloat("interestRate"));
        account.setBankName(resultSet.getString("bankName"));
    }
}
