package com.mahhis.service.impl;

import com.mahhis.dao.FactoryDAO;
import com.mahhis.dao.UserDAO;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.user.User;
import com.mahhis.service.UserService;
import com.mahhis.service.exception.ServiceException;


public class UserServiceImpl implements UserService {
    private static final UserDAO userDAO = FactoryDAO.getInstance().getUserDAO();

    @Override
    public boolean authorisation(String login, String password)throws ServiceException {
        FactoryDAO factory = FactoryDAO.getInstance();
        UserDAO userDAO = factory.getUserDAO();
        boolean result;
        result = userDAO.authorization(login, password);

        return result;
    }

    @Override
    public void registration(User newUser) throws ServiceException {
        if(true){
            try {
                userDAO.registration(newUser);
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }else {throw new ServiceException("чет не то");
        }
    }

    @Override
    public User findByLogin(String login) throws ServiceException {
        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO = factoryDAO.getUserDAO();
        User user;

        try {
            user = userDAO.findByLogin(login);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return user;
    }
}

