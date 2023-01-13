package com.baranbatur.deliveryChainManagement.web.Supplier;

import com.baranbatur.deliveryChainManagement.dao.SupplierDao;
import com.baranbatur.deliveryChainManagement.model.Supplier;
import com.baranbatur.deliveryChainManagement.service.JwtService;
import com.baranbatur.deliveryChainManagement.service.PasswordHash;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login-supplier")
public class LoginSupplierServlet extends HttpServlet {

    PasswordHash passwordHash;

    SupplierDao supplierDao;


    public LoginSupplierServlet() {
        this.passwordHash = new PasswordHash();
        this.supplierDao = new SupplierDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Supplier supplier = this.supplierDao.getSupplierByEmail(email);

        if (supplier == null) {
            ResponseWriter.writeResponse(response, false, "Supplier not found");
        } else {
            boolean isPasswordEqual = this.passwordHash.check(password, supplier.getPassword());
            if (isPasswordEqual) {
                String token = JwtService.generateJwtToken(supplier.getId());
                ResponseWriter.writeResponse(response, true, token);
            } else {
                ResponseWriter.writeResponse(response, false, "Wrong password");
            }
        }
    }
}
