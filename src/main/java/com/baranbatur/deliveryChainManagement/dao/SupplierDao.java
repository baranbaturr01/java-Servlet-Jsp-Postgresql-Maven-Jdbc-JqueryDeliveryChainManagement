package com.baranbatur.deliveryChainManagement.dao;

import com.baranbatur.deliveryChainManagement.model.Supplier;
import com.baranbatur.deliveryChainManagement.service.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SupplierDao extends DbConnection {

    PreparedStatement preparedStatement = null;
    public static final String INSERT_SUPPLIER = "INSERT INTO suppliers (name, email, password, phone) VALUES (?, ?, ?, ?)";

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

}
