package com.db.controller;

import com.db.dto.LoginRequest;
import com.db.entity.User;
import com.db.service.JWTService;
import com.db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    JWTService jwtService;
    UserService userService;


    @Autowired
    AuthenticationController(JWTService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    //Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        System.out.println("--> AUTHENTICATION SERVER/AUTHENTICATION CONTROLLER");
        System.out.println("USERNAME: "+loginRequest.getName()+" PAROLA: "+loginRequest.getPassword());

        //Searching for user in database
        Optional<User> userCredentials = userService.findByName(loginRequest.getName());
        User effectiveUserEntity = userCredentials.orElse(new User());

        System.out.println("EFFECTIVE USER ENTITY: " + effectiveUserEntity);

        //Comparing introduced credentials with actual credentials
        HttpHeaders httpHeaders = new HttpHeaders();
        if (effectiveUserEntity.getName().equals(loginRequest.getName()) &&
                effectiveUserEntity.getPassword().equals(loginRequest.getPassword())) {

            ResponseCookie jwtResponseCookie = ResponseCookie.from
                    ("jwt", jwtService.generateJWT(loginRequest.getName())).maxAge(10000000).build();
            ResponseCookie usernameResponseCookie = ResponseCookie.from
                    ("username", loginRequest.getName()).maxAge(10000).build();

            httpHeaders.set(HttpHeaders.SET_COOKIE, jwtResponseCookie.toString());

            return new ResponseEntity<String>(jwtService.generateJWT(loginRequest.getName()), httpHeaders, HttpStatus.OK);
        } else {
            httpHeaders.set(HttpHeaders.SET_COOKIE, null);
            return new ResponseEntity<String>("Invalid credentials", HttpStatus.BAD_REQUEST);
        }
    }

    //Logout
    @GetMapping("/logout")
    public ResponseEntity<String> logoutResponse() {
        HttpHeaders httpHeaders = new HttpHeaders();
        ResponseCookie responseCookie = ResponseCookie.from("jwt", null).maxAge(0).build();
        httpHeaders.set(HttpHeaders.SET_COOKIE, responseCookie.toString());

        return new ResponseEntity<>(new String("Token deleted"), httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/verify")
    public boolean isLogged(String jwt){
        return jwtService.verifyJWT(jwt);
    }

}
