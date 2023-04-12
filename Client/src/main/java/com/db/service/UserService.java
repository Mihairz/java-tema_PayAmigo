package com.db.service;

import com.db.clients.UsersClient;
import com.db.dto.UserDto;
import com.db.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UsersClient usersClient;

    public void init(){
        System.out.println("Service initialized");
        List<User> userDtoList = requestUsers();
        for (int i=0;i<userDtoList.size();i++){
            System.out.println(userDtoList.get(i));
        }
    }

    public List<User> requestUsers(){
        return usersClient.requestUsers();
    }

}
