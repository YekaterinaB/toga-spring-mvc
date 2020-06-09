package com.springframework.togaspringmvc.controller;
import com.springframework.togaspringmvc.domain.User;
import com.springframework.togaspringmvc.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static final String BASE_URL = "/api/users";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{phoneNumber}")
    public User findUserByPhoneNumber(@PathVariable String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{phoneNumber}")
    public User updateUser(@RequestBody User newUser,@PathVariable String phoneNumber){
        return userService.updateUser(newUser,phoneNumber);
    }

    @DeleteMapping("/{phoneNumber}")
    public void deleteUser(@PathVariable String phoneNumber){
        userService.deleteUser(phoneNumber);
    }

}
