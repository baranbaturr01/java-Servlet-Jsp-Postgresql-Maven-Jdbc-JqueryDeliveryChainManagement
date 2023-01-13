package com.baranbatur.deliveryChainManagement.web.Product;

import com.baranbatur.deliveryChainManagement.dao.ProductDao;
import com.baranbatur.deliveryChainManagement.service.JwtService;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {

    ProductDao productDao;

    public DeleteProductServlet() {
        this.productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = request.getHeader("x-user-token");
        if (token == null) {
            ResponseWriter.writeResponse(response, false, "Unauthorized");
            return;
        }
        String decodedToken = JwtService.parseToken(token);
        if (decodedToken == null) {
            response.sendError(401, "Invalid token");
            return;
        }

        int supplierId = Integer.parseInt(decodedToken);
        int productId = Integer.parseInt(request.getParameter("product_id"));

        productDao.deleteProduct(productId, supplierId);

        ResponseWriter.writeResponse(response, true, "Product deleted");

    }
}
