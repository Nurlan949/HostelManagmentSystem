package com.project.hostelmamagmentsystem.service;

import com.project.hostelmamagmentsystem.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> login(String email, String password);
    User getUserById(Long id);
    List<User> getAllUsers();
    void deleteUser(Long id);

}
