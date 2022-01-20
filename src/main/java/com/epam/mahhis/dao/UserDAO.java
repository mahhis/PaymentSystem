package com.epam.mahhis.dao;

import com.epam.mahhis.entity.user.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

     User findById(int userId) throws SQLException;
     User findByLogin(String userLogin) throws SQLException;

     List<User> findAll() throws SQLException;

     void createUser(User user) throws SQLException;
     void deleteUser(User user) throws SQLException;
     void upDateUser(User user) throws SQLException;

     String authorization(String login, String password);


}
