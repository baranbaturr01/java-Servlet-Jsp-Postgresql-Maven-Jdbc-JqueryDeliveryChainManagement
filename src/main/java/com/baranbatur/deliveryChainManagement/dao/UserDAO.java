package com.baranbatur.deliveryChainManagement.dao;

import com.baranbatur.deliveryChainManagement.model.User;
import com.baranbatur.deliveryChainManagement.service.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends DbConnection {

    final static String INSERT_USER = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
    final static String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private PreparedStatement preparedStatement = null;


    public void insertUser(User user) {
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserByEmail(String email) {
        User user = new User();
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_USER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
}