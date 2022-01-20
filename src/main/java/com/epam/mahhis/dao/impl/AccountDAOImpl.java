package com.epam.mahhis.dao.impl;

import com.epam.mahhis.dao.AccountDAO;
import com.epam.mahhis.dao.builder.BuilderFactory;
import com.epam.mahhis.dao.database.ConnectionPool;
import com.epam.mahhis.dao.database.ConnectionPoolException;
import com.epam.mahhis.entity.account.Account;
import com.epam.mahhis.entity.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    private static final String FIND_ACCOUNT_BY_ID = "SELECT * FROM `bank account` WHERE idBankAccount = ?";
    private static final String FIND_ACCOUNT_BY_NUMBER_ACCOUNT = "SELECT * FROM `bank account` WHERE numberBankAccount = ?";
    private static final String FIND_ALL_USER = "SELECT * FROM `bank account`";
    private static final String CREATE_NEW_ACCOUNT = "INSERT `bank account`(numberBankAccount, idUsers, currency, countValue, interestRate, bankName) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_INTEREST_RATE = "UPDATE `bank account` SET interestRate = ? WHERE idBankAccount = ?";
    private static final String UPDATE_COUNT_VALUE = "UPDATE `bank account` SET countValue = ? WHERE idBankAccount = ?";
    private static final String DELETE_ACCOUNT = "DELETE FROM `bank account` WHERE idBankAccount = ?";

    @Override
    public Account findByID(int idAccount) throws SQLException {
        Account account = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ACCOUNT_BY_ID;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idAccount);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                account = BuilderFactory.getAccountBuilder().buildAccount(resultSet);
            } else {
                account = new Account();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            resultSet.close();
            statement.close();
        }
        return account;
    }

    @Override
    public Account findByNumberAccount(String numberAccount) throws SQLException {
        Account account = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ACCOUNT_BY_NUMBER_ACCOUNT;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, numberAccount);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                account = BuilderFactory.getAccountBuilder().buildAccount(resultSet);
            } else {
                account = new Account();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
            resultSet.close();
            statement.close();
        }
        return account;
    }

    @Override
    public List<Account> findAll() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_USER;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                accounts.add(BuilderFactory.getAccountBuilder().buildAccount(resultSet));
            }
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            resultSet.close();
            statement.close();
        }
        return accounts;
    }

    @Override
    public void createAccount(Account account) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_ACCOUNT;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, account.getNumberAccount());
            statement.setInt(2, account.getIdUser());
            statement.setString(3, account.getCurrency());
            statement.setLong(4, account.getCountValue());
            statement.setFloat(5, account.getInterestRate());
            statement.setString(6, account.getBankName());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    @Override
    public void deleteAccount(Account account) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = DELETE_ACCOUNT;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, account.getIdAccount());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    @Override
    public void upDateInterestRate(Account account, float newInterestRate) throws SQLException {


        Connection connection = null;
        PreparedStatement statement = null;
        String sql = UPDATE_INTEREST_RATE;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setFloat(1, newInterestRate);
            statement.setInt(2, account.getIdAccount());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    @Override
    public void changeCountValue(Account account, int countValue) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = UPDATE_COUNT_VALUE;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, countValue);
            statement.setInt(2, account.getIdAccount());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

}
