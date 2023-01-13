package com.baranbatur.deliveryChainManagement.dao;

import com.baranbatur.deliveryChainManagement.model.Product;
import com.baranbatur.deliveryChainManagement.service.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends DbConnection {

    private PreparedStatement preparedStatement = null;
    private static final String INSERT_PRODUCT = "INSERT INTO products (name, description, price,stock, image,supplier_id) VALUES (?, ?, ?, ?,?,?)";

    //get all products with supplier id join
    private static final String GET_ALL_PRODUCTS = "SELECT products.id, products.name, " + "products.description, products.price, products.stock, products.image, products.supplier_id, suppliers.name as supplier_name" + " FROM products INNER JOIN suppliers ON products.supplier_id = suppliers.id";
    private static final String UPDATE_PRODUCT = "UPDATE products SET name = ?, description = ?, price = ?,stock = ?, image = ? WHERE id = ? AND supplier_id = ?";
    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE id = ? AND supplier_id = ?";


    public void addProduct(Product product) {

        try {
            this.preparedStatement = getConnection().prepareStatement(INSERT_PRODUCT);
            this.preparedStatement.setString(1, product.getName());
            this.preparedStatement.setString(2, product.getDescription());
            this.preparedStatement.setInt(3, product.getPrice());
            this.preparedStatement.setInt(4, product.getStock());
            this.preparedStatement.setString(5, product.getImage());
            this.preparedStatement.setInt(6, product.getSupplier_id());
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Product> getAllProducts() {

        List<Product> productList = new ArrayList<>();
        try {
            this.preparedStatement = getConnection().prepareStatement(GET_ALL_PRODUCTS);
            ResultSet resultSet = this.preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getInt("price"));
                product.setStock(resultSet.getInt("stock"));
                product.setImage(resultSet.getString("image"));
                product.setSupplier_id(resultSet.getInt("supplier_id"));
                product.setSupplierName(resultSet.getString("supplier_name"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return productList;
    }

    public void updateProduct(int productId, String name, String description, int price, int stock, String image, int supplierId) {
        try {
            this.preparedStatement = getConnection().prepareStatement(UPDATE_PRODUCT);
            this.preparedStatement.setString(1, name);
            this.preparedStatement.setString(2, description);
            this.preparedStatement.setInt(3, price);
            this.preparedStatement.setInt(4, stock);
            this.preparedStatement.setString(5, image);
            this.preparedStatement.setInt(6, productId);
            this.preparedStatement.setInt(7, supplierId);
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId, int supplierId) {
        try {
            this.preparedStatement = getConnection().prepareStatement(UPDATE_PRODUCT);
            this.preparedStatement.setInt(1, productId);
            this.preparedStatement.setInt(2, supplierId);
            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
