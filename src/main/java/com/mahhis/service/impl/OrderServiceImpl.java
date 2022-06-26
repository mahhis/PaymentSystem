package com.mahhis.service.impl;

import com.mahhis.dao.FactoryDAO;
import com.mahhis.dao.OrderDAO;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.order.Order;
import com.mahhis.entity.user.User;
import com.mahhis.service.OrderService;
import com.mahhis.service.exception.ServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Override
    public Order findByCardNumberGetter(Long cardNumber) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        OrderDAO orderDAO = factoryDAO.getOrderDAO();
        Order order;
        try {
            order = orderDAO.findByCardNumberGetter(cardNumber);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return order;
    }
    @Override
    public List<Order> findAllFromUser(User user) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        OrderDAO orderDAO = factoryDAO.getOrderDAO();
        List<Order> userOrders;
        try {
            userOrders =orderDAO.findAllFromUser(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return userOrders;
    }

    @Override
    public void createOrder(Order order) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        OrderDAO orderDAO = factoryDAO.getOrderDAO();
        try {
            orderDAO.createOrder(order);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateOrder(Order order) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        OrderDAO orderDAO = factoryDAO.getOrderDAO();
        try {
            orderDAO.updateOrder(order);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
