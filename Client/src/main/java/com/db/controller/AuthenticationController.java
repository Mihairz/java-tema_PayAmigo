package com.db.controller;

import com.db.dto.LoginRequest;
import com.db.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        System.out.println("-->CLIENT/AUTHENTICATION CONTROLLER");
        return authenticationService.login(loginRequest);
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout(){
        System.out.println("-->CLIENT/LOGOUT CONTROLLER");
        return authenticationService.logout();
    }
}
