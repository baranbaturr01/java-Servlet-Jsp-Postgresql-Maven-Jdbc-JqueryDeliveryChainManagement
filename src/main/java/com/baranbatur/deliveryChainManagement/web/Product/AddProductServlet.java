package com.baranbatur.deliveryChainManagement.web.Product;

import com.baranbatur.deliveryChainManagement.service.ResponseWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session.getAttribute("supplier_id") == null) {
            ResponseWriter.writeResponse(response, false, "You are not logged in");
        } else {


            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String price = request.getParameter("price");
            String quantity = request.getParameter("quantity");
            String supplier_id = request.getParameter("supplier_id");

            boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        }
    }
}
