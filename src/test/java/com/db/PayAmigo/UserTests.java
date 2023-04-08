package com.db.PayAmigo;

import com.db.PayAmigo.entity.User;
import com.db.PayAmigo.service.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;

import java.util.Optional;

@SpringBootTest
public class UserTests {
    @Autowired
    UserService userService;
    @org.junit.jupiter.api.Test
    public void addUser(){
        // org.junit.Assert.assertThrows(NumeExceptie.class,()->{userService.save(invalidUser);})
        User newUser = new User("Mike","mike@yahoo.com","123");
        userService.save(newUser);
        User newUser1 = userService.findByUserId(newUser.getId());
        Assertions.assertEquals(newUser, newUser1, "User nu e identic cu user1");
    }
}
