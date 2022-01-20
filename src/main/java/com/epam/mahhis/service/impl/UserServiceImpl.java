package com.epam.mahhis.service.impl;

import com.epam.mahhis.dao.FactoryDAO;
import com.epam.mahhis.dao.UserDAO;
import com.epam.mahhis.dao.impl.UserDAOImpl;
import com.epam.mahhis.entity.user.User;
import com.epam.mahhis.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public String authorisation(String login, String password) {


        FactoryDAO factoryDAO = FactoryDAO.getInstance();
        UserDAO userDAO = factoryDAO.getUserDAO();

        String role = null;
        try {
            role = userDAO.authorization(login, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public boolean registration(User newUser) {
        return false;
    }
}
