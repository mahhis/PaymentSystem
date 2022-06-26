package com.mahhis.service;

import com.mahhis.entity.user.User;
import com.mahhis.service.exception.ServiceException;

public interface UserService {

    boolean authorisation(String login, String password)throws ServiceException;
    void registration(User newUser) throws ServiceException;
    User findByLogin(String login) throws ServiceException;
}
