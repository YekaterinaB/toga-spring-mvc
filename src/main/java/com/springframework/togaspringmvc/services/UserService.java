package com.springframework.togaspringmvc.services;

import com.springframework.togaspringmvc.domain.User;

import java.util.List;

public interface UserService {

    User findUserByPhoneNumber(String phoneNumber);

    User saveUser(User user);

    User updateUser(User user, String phoneNumber);

    void deleteUser(String phoneNumber);

    List<User> getAllUsers();
}
