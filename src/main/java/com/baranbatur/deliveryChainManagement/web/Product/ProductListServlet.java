package com.baranbatur.deliveryChainManagement.web.Product;

import com.baranbatur.deliveryChainManagement.dao.ProductDao;
import com.baranbatur.deliveryChainManagement.model.Product;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/product-list")
public class ProductListServlet extends HttpServlet {

    ProductDao productDao;

    public ProductListServlet() {
        this.productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product> productList = new ArrayList<>();
        productList = productDao.getAllProducts();

        ResponseWriter.writeResponse(response, true, productList);

    }
}
