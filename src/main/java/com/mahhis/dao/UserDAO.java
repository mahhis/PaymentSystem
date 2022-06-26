package com.mahhis.dao;

import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.user.User;

import java.util.List;

public interface UserDAO {

     User findById(int userId) throws DAOException;
     User findByLogin(String userLogin) throws DAOException;

     List<User> findAll() throws DAOException;


     void deleteUser(User user) throws DAOException;
     void upDateUser(User user) throws DAOException;

     boolean authorization(String login, String password);
     void registration(User user) throws DAOException;

}
