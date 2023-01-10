package com.baranbatur.deliveryChainManagement.dao;

import com.baranbatur.deliveryChainManagement.service.DbConnection;

public class ProductDao extends DbConnection {

    private static final String INSERT_PRODUCT = "INSERT INTO products (name, description, price, image) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, description = ?, price = ?, image = ? WHERE id = ?";
    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";


}
