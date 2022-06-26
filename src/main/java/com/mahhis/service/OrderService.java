package com.mahhis.service;

import com.mahhis.entity.order.Order;
import com.mahhis.entity.user.User;
import com.mahhis.service.exception.ServiceException;

import java.util.List;

public interface OrderService {
    Order findByCardNumberGetter(Long cardNumber)throws ServiceException;
    List<Order> findAllFromUser(User user) throws ServiceException;
    void createOrder(Order order) throws ServiceException;
    void updateOrder(Order order) throws ServiceException;
}
