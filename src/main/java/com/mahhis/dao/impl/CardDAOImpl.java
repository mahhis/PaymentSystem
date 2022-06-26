package com.mahhis.dao.impl;

import com.mahhis.dao.CardDAO;
import com.mahhis.dao.builder.BuilderFactory;
import com.mahhis.dao.database.ConnectionPool;
import com.mahhis.dao.database.ConnectionPoolException;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.card.Card;
import com.mahhis.entity.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDAOImpl implements CardDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String FIND_CARD_BY_ID = "SELECT * FROM `card` WHERE idCard = ?";
    private static final String FIND_CARD_BY_NUMBER_CARD = "SELECT * FROM `card` WHERE cardNumber = ?";
    private static final String FIND_ALL_CARDS = "SELECT * FROM `card` WHERE idUsers = ?";
    private static final String CREATE_NEW_CARD = "INSERT `card`(cardNumber, cardValidityDate, CVV, bankName, countryName, idUser) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String DELETE_CARD = "DELETE FROM `card` WHERE idCard = ?";


    @Override
    public Card findByID(int idCard) throws DAOException {
        Card card = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_CARD_BY_ID;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idCard);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                card = BuilderFactory.getCardBuilder().buildCard(resultSet);
            } else {
                card = new Card();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return card;
    }

    @Override
    public Card findByNumberAccount(String numberCard) throws DAOException {
        Card card = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_CARD_BY_NUMBER_CARD;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, numberCard);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                card = BuilderFactory.getCardBuilder().buildCard(resultSet);
            } else {
                card = new Card();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return card;
    }

    @Override
    public List<Card> findAll(User user) throws DAOException {
        List<Card> cards = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_CARDS;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cards.add(BuilderFactory.getCardBuilder().buildCard(resultSet));
            }
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return cards;
    }

    @Override
    public void createAccount(Card card) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_CARD;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, card.getCardNumber());
            statement.setString(2, card.getCardValidityDate());
            statement.setShort(3, card.getCvv());
            statement.setString(4, card.getBankName());
            statement.setString(5, card.getCountryName());
            statement.setInt(6, card.getIdUser());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteAccount(Card card) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = DELETE_CARD;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, card.getIdCard());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }
}
