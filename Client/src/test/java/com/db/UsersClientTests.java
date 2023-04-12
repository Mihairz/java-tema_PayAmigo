package com.db;

import com.db.clients.UsersClient;
import com.db.dto.UserDto;
import com.db.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

//@SpringBootTest(classes = UsersClient.class)
@ExtendWith(SpringExtension.class)
public class UsersClientTests {
    @Autowired
    UsersClient usersClient;

    @Test
    public void requestUsers(){
        List<User> responseUsers = usersClient.requestUsers();
        int noExpectedUsers = 4;
        assert (noExpectedUsers == responseUsers.size());
    }
}
