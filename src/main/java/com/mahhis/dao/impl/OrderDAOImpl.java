package com.mahhis.dao.impl;

import com.mahhis.dao.OrderDAO;
import com.mahhis.dao.builder.BuilderFactory;
import com.mahhis.dao.database.ConnectionPool;
import com.mahhis.dao.database.ConnectionPoolException;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.order.Order;
import com.mahhis.entity.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String FIND_ORDER_BY_CARD_NUMBER = "SELECT * FROM `orders` WHERE cardNumberGetter = ?";
    private static final String FIND_ALL_ORDERS_FROM_ONE_USER = "SELECT * FROM `orders` WHERE idUser = ?";
    private static final String FIND_ALL_ORDERS= "SELECT * FROM `orders`";
    private static final String CREATE_NEW_ORDER = "INSERT INTO  `orders` (complete, cardNumberGetter, getterCountry, bankNameGetter, sumToComplete, idUser) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_ORDER = "UPDATE `orders` SET complete = ?, sumToComplete = ? WHERE cardNumberGetter = ?";


    @Override
    public Order findByCardNumberGetter(Long cardNumber) throws DAOException {
        Order order = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ORDER_BY_CARD_NUMBER;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, cardNumber);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = BuilderFactory.getOrderBuilder().buildOrder(resultSet);
            } else {
                order = new Order();
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
        return order;
    }

    @Override
    public List<Order> findAllFromUser(User user) throws DAOException {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_ORDERS_FROM_ONE_USER;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(BuilderFactory.getOrderBuilder().buildOrder(resultSet));
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
        return orders;
    }

    @Override
    public List<Order> findAll() throws DAOException {
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_ORDERS;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orders.add(BuilderFactory.getOrderBuilder().buildOrder(resultSet));
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
        return orders;
    }



    @Override
    public void createOrder(Order order) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_ORDER;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, order.isComplete());
            statement.setLong(2, order.getCardNumberGetter());
            statement.setString(3, order.getGetterCountry());
            statement.setString(4, order.getBankNameGetter());
            statement.setDouble(5, order.getSumToComplete());
            statement.setInt(6, order.getUser().getId());
            statement.executeUpdate();
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
    public void updateOrder(Order order) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = UPDATE_ORDER;
        try {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, order.isComplete());
            statement.setDouble(2, order.getSumToComplete());
            statement.setLong(3, order.getCardNumberGetter());
            statement.executeUpdate();
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
