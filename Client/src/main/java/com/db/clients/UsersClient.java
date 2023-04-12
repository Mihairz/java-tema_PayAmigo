package com.db.clients;

import com.db.configuration.ClientConfiguration;

import com.db.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Component
@FeignClient(url = "http://localhost:8082/user", value = "clients", configuration = ClientConfiguration.class)
public interface UsersClient {
    @RequestMapping(method= RequestMethod.GET, value = "/all-json")
    List<User> requestUsers();
}
