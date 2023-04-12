package com.db.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {
    private Algorithm algorithm = Algorithm.HMAC256("secret");

    public String generateJWT(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuer("db")
                .withIssuedAt(new Date())
                .sign(algorithm);
    }


    public boolean verifyJWT(String jwt) {
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            jwtVerifier.verify(jwt);
        } catch (JWTVerificationException jwtVerificationException) {
            return false;
        }
        return true;
    }
}
