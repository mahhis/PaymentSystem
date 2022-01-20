package com.epam.mahhis.service;

import com.epam.mahhis.entity.user.User;

public interface UserService {

    String authorisation(String login, String password);
    boolean registration(User newUser);
}
