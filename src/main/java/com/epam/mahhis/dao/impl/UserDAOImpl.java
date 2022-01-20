package com.epam.mahhis.dao.impl;

import com.epam.mahhis.dao.UserDAO;
import com.epam.mahhis.dao.builder.BuilderFactory;
import com.epam.mahhis.dao.database.ConnectionPool;
import com.epam.mahhis.dao.database.ConnectionPoolException;
import com.epam.mahhis.entity.user.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static final String FIND_USER_BY_ID = "SELECT * FROM `users` WHERE idUsers = ?";
    private static final String FIND_USER_BY_LOGIN = "SELECT * FROM `users` WHERE login = ?";
    private static final String FIND_ALL_USER = "SELECT * FROM users";
    private static final String CREATE_NEW_USER = "INSERT users(login) VALUES (?);";
    private static final String UPDATE_USER = "UPDATE users SET login = ? WHERE idUsers = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE idUsers = ?";


    @Override
    public User findById(int userId) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_USER_BY_ID;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = BuilderFactory.getUserBuild().buildUser(resultSet);
            } else {
                user = new User();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            resultSet.close();
            statement.close();
        }
        return user;
    }

    @Override
    public User findByLogin(String userLogin) throws SQLException {
        User user = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_USER_BY_LOGIN;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, userLogin);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = BuilderFactory.getUserBuild().buildUser(resultSet);
            } else {
                user = new User();
            }

        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
           connection.close();
           resultSet.close();
           statement.close();
        }
        return user;
    }

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = FIND_ALL_USER;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
               users.add(BuilderFactory.getUserBuild().buildUser(resultSet));
            }
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            resultSet.close();
            statement.close();
        }
        return users;
    }

    @Override
    public void createUser(User user) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = CREATE_NEW_USER;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    @Override
    public void deleteUser(User user) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;
        String sql = DELETE_USER;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }


    @Override
    public void upDateUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = UPDATE_USER;
        try {
            connection = ConnectionPool.getInstance().connection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getLogin());
            statement.setInt(2, user.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (ConnectionPoolException | SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
            statement.close();
        }
    }

    @Override
    public String authorization(String login, String password) {
        return null;
    }
}
