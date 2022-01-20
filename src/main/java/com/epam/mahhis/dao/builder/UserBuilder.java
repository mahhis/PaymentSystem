package com.epam.mahhis.dao.builder;

import com.epam.mahhis.entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder {

    public User buildUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        build(user, resultSet);
        return user;
    }

    private void build(User user, ResultSet resultSet) throws SQLException {
        user.setId(resultSet.getInt("idUsers"));
        user.setLogin(resultSet.getString("login"));
    }
}
