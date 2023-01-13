package com.baranbatur.deliveryChainManagement.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class JwtService {
    private static final String SECRET_KEY = "secretkey";
    private static final long EXPIRATION_TIME = 864_000_000;

    public static String generateJwtToken(int id) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 10);
        Date expirationDate = cal.getTime();
        return JWT.create().withSubject(String.valueOf(id)).withExpiresAt(expirationDate).sign(Algorithm.HMAC512(SECRET_KEY));

    }

    public static String parseToken(String token) {

        DecodedJWT decodedJWT = JWT.require(Algorithm.HMAC512(SECRET_KEY)).build().verify(token);
        return decodedJWT.getSubject();
    }
}
