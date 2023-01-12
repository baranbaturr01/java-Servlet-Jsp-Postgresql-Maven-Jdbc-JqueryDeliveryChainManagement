package com.baranbatur.deliveryChainManagement.bussiness;

import com.baranbatur.deliveryChainManagement.model.Supplier;
import com.baranbatur.deliveryChainManagement.model.User;

public class SupplierResponse {
    private int id;
    private String name;
    private String email;
    private String phone;

    public SupplierResponse(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static SupplierResponse from(Supplier supplier) {
        return new SupplierResponse(supplier.getId(), supplier.getName(), supplier.getEmail(), supplier.getPhone());
    }


}

