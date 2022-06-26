package com.mahhis.dao.builder;

import com.mahhis.dao.FactoryDAO;
import com.mahhis.dao.UserDAO;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.order.Order;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderBuilder {
    public Order buildOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        build(order, resultSet);
        return order;
    }

    private void build(Order order, ResultSet resultSet) throws SQLException {

        UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();
        try {
            order.setUser(userDAO.findById(resultSet.getInt("idUser")));

        } catch (DAOException e) {
            e.printStackTrace();
        }
        order.setIdOrder(resultSet.getInt("idOrder"));
        order.setComplete(resultSet.getBoolean("complete"));
        order.setCardNumberGetter(resultSet.getLong("cardNumberGetter"));
        order.setSumToComplete(resultSet.getDouble("sumToComplete"));
        order.setBankNameGetter(resultSet.getString("bankNameGetter"));
        order.setGetterCountry(resultSet.getString("getterCountry"));
    }
}
