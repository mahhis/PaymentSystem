package com.mahhis.dao;

import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.order.Order;
import com.mahhis.entity.user.User;

import java.util.List;

public interface OrderDAO {


    Order findByCardNumberGetter(Long cardNumber) throws DAOException;
    List<Order> findAllFromUser(User user) throws DAOException;
    List<Order> findAll() throws DAOException;
    void createOrder(Order order) throws DAOException;
    void updateOrder(Order order) throws DAOException;

}
