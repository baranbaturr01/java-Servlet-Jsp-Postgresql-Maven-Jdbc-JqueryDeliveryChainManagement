package com.baranbatur.deliveryChainManagement.web.Supplier;

import com.baranbatur.deliveryChainManagement.bussiness.SupplierResponse;
import com.baranbatur.deliveryChainManagement.bussiness.userResponse.UserResponse;
import com.baranbatur.deliveryChainManagement.dao.SupplierDao;
import com.baranbatur.deliveryChainManagement.model.Supplier;
import com.baranbatur.deliveryChainManagement.model.User;
import com.baranbatur.deliveryChainManagement.service.PasswordHash;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import com.baranbatur.deliveryChainManagement.web.User.RegisterServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/registerSupplier")
public class RegisterSupplierServlet extends HttpServlet {

    SupplierDao supplierDao;
    PasswordHash passwordHash;

    public RegisterSupplierServlet() {
        this.supplierDao = new SupplierDao();
        this.passwordHash = new PasswordHash();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login-registerSupplier.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        String passwordHashed = this.passwordHash.hash(password);

        Supplier supplier = new Supplier(name, email, passwordHashed, phone);

        this.supplierDao.insertSupplier(supplier);

        HttpSession session = request.getSession();
        session.setAttribute("supplier_id", supplier.getId());

        ResponseWriter.writeResponse(response, true, SupplierResponse.from(supplier));
    }
}
