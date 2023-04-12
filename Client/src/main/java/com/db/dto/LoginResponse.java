package com.db.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String jwt;
    private boolean isSuccessful;

    public LoginResponse(String jwt, boolean isSuccessful) {
        this.jwt = jwt;
        this.isSuccessful = isSuccessful;
    }
}
