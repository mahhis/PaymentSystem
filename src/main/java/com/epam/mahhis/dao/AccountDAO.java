package com.epam.mahhis.dao;

import com.epam.mahhis.entity.account.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {

    Account findByID(int idAccount) throws SQLException;
    Account findByNumberAccount(String numberAccount) throws SQLException;
    List<Account> findAll() throws SQLException;
    void createAccount(Account account) throws SQLException;
    void deleteAccount(Account account) throws SQLException;
    void upDateInterestRate(Account account, float newInterestRate) throws SQLException;
    void changeCountValue(Account account, int countValue) throws SQLException;
}
