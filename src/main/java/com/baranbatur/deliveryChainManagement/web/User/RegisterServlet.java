package com.baranbatur.deliveryChainManagement.web.User;

import com.baranbatur.deliveryChainManagement.bussiness.userResponse.UserResponse;
import com.baranbatur.deliveryChainManagement.dao.UserDAO;
import com.baranbatur.deliveryChainManagement.model.User;
import com.baranbatur.deliveryChainManagement.service.PasswordHash;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO;
    private PasswordHash passwordHash;

    public RegisterServlet() {
        this.userDAO = new UserDAO();
        this.passwordHash = new PasswordHash();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("./LoginRegister/register.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String passwordHashed = this.passwordHash.hash(password);
        System.out.println(name + " " + email + " " + password);

        User user = new User(name, email, passwordHashed);

        userDAO.insertUser(user);

        //response json

        ResponseWriter.writeResponse(response, true, UserResponse.from(user));
    }
}
