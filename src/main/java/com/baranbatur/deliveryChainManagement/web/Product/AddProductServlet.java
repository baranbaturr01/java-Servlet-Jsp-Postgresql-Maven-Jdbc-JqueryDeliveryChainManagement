package com.baranbatur.deliveryChainManagement.web.Product;

import com.baranbatur.deliveryChainManagement.dao.ProductDao;
import com.baranbatur.deliveryChainManagement.model.Product;
import com.baranbatur.deliveryChainManagement.service.JwtService;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {

    ProductDao productDao;

    public AddProductServlet() {
        this.productDao = new ProductDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        String image = "image";
        Product product = new Product(name, description, price, stock, image, supplierId);

        productDao.addProduct(product);
        ResponseWriter.writeResponse(response, true, "Product added successfully");

    }
}
