package com.db.PayAmigo.controller;

import com.db.PayAmigo.entity.User;
import com.db.PayAmigo.exception.UserNotFoundException;
import com.db.PayAmigo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users---------------------------------------------------------------------------------------------

    @GetMapping("/all-json")
    public List<User> getAllUsersJSON() {
        return userService.findAllUsers();
    }

    // Get user by userId---------------------------------------------------------------------------------

    @GetMapping("/by-id-json/{userId}")
    public User findByIdJSON(@PathVariable(name = "userId") int userId) throws UserNotFoundException {
        User user = userService.findByUserId(userId);
        if(user == null){
            throw new UserNotFoundException(userId);
        }
        return userService.findByUserId(userId);
    }


    // Add user--------------------------------------------------------------------------------------------------

    @PutMapping("/add-json")
    public User addUserJSON(@RequestBody User user) {
        return userService.save(user);
    }

    // Update user-----------------------------------------------------------------------------------------------

    @PostMapping("/update-json/{id}")
    public User updateUserJSON(@PathVariable(name = "id") int id,
                               @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Delete user-----------------------------------------------------------------------------------------------
    @DeleteMapping("/delete/{userId}")
    public void deleteTransaction(@PathVariable(name = "userId") int userId) {
        userService.deleteUser(userId);
    }
}
