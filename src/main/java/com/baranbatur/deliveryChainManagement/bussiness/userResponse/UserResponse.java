package com.baranbatur.deliveryChainManagement.bussiness.userResponse;

import com.baranbatur.deliveryChainManagement.model.User;

public class UserResponse {
    private int id;
    private String name;
    private String email;

    public UserResponse(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

}

