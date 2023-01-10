package com.baranbatur.deliveryChainManagement.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHash {


    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
