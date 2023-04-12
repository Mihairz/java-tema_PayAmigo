package com.db.service;

import com.db.clients.AuthenticationClient;
import com.db.clients.UsersClient;
import com.db.dto.LoginRequest;
import com.db.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    AuthenticationClient authenticationClient;

    public void init(){
        System.out.println("Authentication service initialized");
    }

    public ResponseEntity<String> login(LoginRequest loginRequest){
        System.out.println("-->CLIENT/ AUTHENTICATION SERVICE");
        return authenticationClient.login(loginRequest);
    }

    public ResponseEntity<String> logout(){
        System.out.println("-->CLIENT/ LOGOUT SERVICE");
        return authenticationClient.logout();
    }
}
