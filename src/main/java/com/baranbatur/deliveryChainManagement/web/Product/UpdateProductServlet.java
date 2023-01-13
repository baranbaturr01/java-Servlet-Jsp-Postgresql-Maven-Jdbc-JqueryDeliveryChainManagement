package com.baranbatur.deliveryChainManagement.web.Product;

import com.baranbatur.deliveryChainManagement.dao.ProductDao;
import com.baranbatur.deliveryChainManagement.model.Product;
import com.baranbatur.deliveryChainManagement.service.JwtService;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
    ProductDao productDao;

    public UpdateProductServlet() {
        this.productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO: Update product Page
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = request.getHeader("x-user-token");
        if (token == null) {
            ResponseWriter.writeResponse(response, false, "Token not found");
            return;
        }
        String decodedToken = JwtService.parseToken(token);
        if (decodedToken == null) {
            response.sendError(401, "Invalid token");
            return;
        }

        int supplierId = Integer.parseInt(decodedToken);
        int productId = Integer.parseInt(request.getParameter("product_id"));

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = "image";

        productDao.updateProduct(productId, name, description, price, stock, image, supplierId);


        ResponseWriter.writeResponse(response, true, "Product updated successfully");
    }
}
