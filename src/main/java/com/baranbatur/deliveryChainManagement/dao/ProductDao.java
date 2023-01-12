package com.baranbatur.deliveryChainManagement.dao;

import com.baranbatur.deliveryChainManagement.model.Product;
import com.baranbatur.deliveryChainManagement.service.DbConnection;

import java.sql.PreparedStatement;
import java.util.List;

public class ProductDao extends DbConnection {

    private PreparedStatement preparedStatement = null;
    private static final String INSERT_PRODUCT = "INSERT INTO products (name, description, price, image) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, description = ?, price = ?, image = ? WHERE id = ?";
    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";


    public void addProduct(Product product) {

        try {
            this.preparedStatement = getConnection().prepareStatement(INSERT_PRODUCT);
            this.preparedStatement.setString(1, product.getName());
            this.preparedStatement.setString(2, product.getDescription());
            this.preparedStatement.setDouble(3, product.getPrice());
            this.preparedStatement.setString(4, product.getImage());
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
