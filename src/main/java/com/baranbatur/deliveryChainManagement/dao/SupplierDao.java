package com.baranbatur.deliveryChainManagement.dao;

import com.baranbatur.deliveryChainManagement.model.Supplier;
import com.baranbatur.deliveryChainManagement.service.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDao extends DbConnection {

    PreparedStatement preparedStatement = null;
    public static final String INSERT_SUPPLIER = "INSERT INTO suppliers (name, email, password, phone) VALUES (?, ?, ?, ?)";
    public static final String SELECT_SUPPLIER_BY_EMAIL = "SELECT * FROM suppliers WHERE email = ?";

    public void insertSupplier(Supplier supplier) {
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_SUPPLIER);
            preparedStatement.setString(1, supplier.getName());
            preparedStatement.setString(2, supplier.getEmail());
            preparedStatement.setString(3, supplier.getPassword());
            preparedStatement.setString(4, supplier.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Supplier getSupplierByEmail(String email) {
        Supplier supplier = new Supplier();
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_SUPPLIER_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                supplier.setId(resultSet.getInt("id"));
                supplier.setName(resultSet.getString("name"));
                supplier.setEmail(resultSet.getString("email"));
                supplier.setPassword(resultSet.getString("password"));
                supplier.setPhone(resultSet.getString("phone"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;


    }
}
