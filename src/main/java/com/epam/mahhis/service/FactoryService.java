package com.epam.mahhis.service;

import com.epam.mahhis.service.impl.UserServiceImpl;

public final class FactoryService {

    private static final FactoryService instance = new FactoryService();

    private final UserService userService = new UserServiceImpl();

    private FactoryService(){}

    public static FactoryService getInstance(){
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }
}
