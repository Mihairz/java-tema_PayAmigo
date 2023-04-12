package com.db.clients;

import com.db.configuration.ClientConfiguration;
import com.db.dto.LoginRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(url = "http://localhost:8083/authentication", value = "credentials", configuration = ClientConfiguration.class)
public interface AuthenticationClient {
    @RequestMapping(method= RequestMethod.POST, value = "/login")
    ResponseEntity<String> login(LoginRequest loginRequest);

    @RequestMapping(method= RequestMethod.GET, value = "/logout")
    ResponseEntity<String> logout();


}
