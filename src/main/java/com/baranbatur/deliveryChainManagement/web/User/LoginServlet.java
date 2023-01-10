package com.baranbatur.deliveryChainManagement.web.User;

import com.baranbatur.deliveryChainManagement.bussiness.userResponse.UserResponse;
import com.baranbatur.deliveryChainManagement.dao.UserDAO;
import com.baranbatur.deliveryChainManagement.service.PasswordHash;
import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO;
    private PasswordHash passwordHash;

    public LoginServlet() {
        this.userDAO = new UserDAO();
        this.passwordHash = new PasswordHash();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("./LoginRegister/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (userDAO.getUserByEmail(email).getEmail() != null) {
            if (passwordHash.check(password, userDAO.getUserByEmail(email).getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("user", userDAO.getUserByEmail(email));
                ResponseWriter.writeResponse(response, true, UserResponse.from(userDAO.getUserByEmail(email)));
            } else {
                ResponseWriter.writeResponse(response, false, "Wrong password");
            }
        } else {
            ResponseWriter.writeResponse(response, false, "User not found");
        }


    }
}
