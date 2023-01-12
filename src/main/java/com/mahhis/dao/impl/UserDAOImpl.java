package com.mahhis.dao.impl;

import com.mahhis.controller.constants.ParameterName;
import com.mahhis.dao.UserDAO;
import com.mahhis.dao.builder.BuilderFactory;
import com.mahhis.dao.database.ConnectionPool;
import com.mahhis.dao.database.ConnectionPoolException;
import com.mahhis.dao.exception.DAOException;
import com.mahhis.entity.user.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String FIND_USER_BY_ID = "SELECT * FROM `users` WHERE idUsers = ?";
    private static final String FIND_USER_BY_LOGIN = "SELECT * FROM `users` WHERE login = ?";
    private static final String FIND_ALL_USER = "SELECT * FROM users";
    private static final String CREATE_NEW_USER = "INSERT INTO  `users` (password, login, email) VALUES (?, ?, ?);";
    private static final String UPDATE_USER = "UPDATE users SET login = ? WHERE idUsers = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE idUsers = ?";
    private final static String AUTHORIZATION_USER  = "SELECT * FROM users WHERE login = ?";





    @Override
    public void registration(User user) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_USER;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            statement.setString(1, hashed);
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean authorization(String login, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        boolean result = false;
        String sql = AUTHORIZATION_USER;

        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if(resultSet.next() && BCrypt.checkpw(password, resultSet.getString(ParameterName.PASSWORD))){
                result = true;
            }
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }

        return result;
    }


    @Override
    public User findById(int idUsers) throws DAOException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_USER_BY_ID;

        try {
            System.out.println(14);
            connection = connectionPool.takeConnection();
            System.out.println(15);
            statement = connection.prepareStatement(sql);
            System.out.println(16);
            statement.setInt(1, idUsers);
            System.out.println(17);
            resultSet = statement.executeQuery();
            System.out.println("234234"+resultSet.toString());
            if (resultSet.next()) {
                user = BuilderFactory.getUserBuild().buildUser(resultSet);
            } else {
                user = new User();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println(18);
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public User findByLogin(String userLogin) throws DAOException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_USER_BY_LOGIN;
        System.out.println(13);
        try {
            System.out.println(14);
            connection = connectionPool.takeConnection();
            System.out.println(15);
            statement = connection.prepareStatement(sql);
            System.out.println(16);
            statement.setString(1, userLogin);
            System.out.println(17);
            resultSet = statement.executeQuery();
            System.out.println(18);
            if (resultSet.next()) {
                System.out.println(19);
                user = BuilderFactory.getUserBuild().buildUser(resultSet);
            } else {
                user = new User();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                System.out.println(20);
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() throws DAOException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_USER;
        try {
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
               users.add(BuilderFactory.getUserBuild().buildUser(resultSet));
            }
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement, resultSet);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
        return users;
    }



    @Override
    public void deleteUser(User user) throws DAOException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = DELETE_USER;
        try {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void upDateUser(User user) throws DAOException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = UPDATE_USER;
        try {
            connectionPool = ConnectionPool.getInstance();
            connection = connectionPool.takeConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connectionPool.closeConnection(connection, statement);
            } catch (ConnectionPoolException e) {
                e.printStackTrace();
            }
        }
    }
}
