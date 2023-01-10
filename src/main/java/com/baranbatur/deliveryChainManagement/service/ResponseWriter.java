package com.baranbatur.deliveryChainManagement.service;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ResponseWriter {
    public static void writeResponse(HttpServletResponse response, boolean success, Object data) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new Gson().toJson(new Response<>(success, data)));
    }
}
