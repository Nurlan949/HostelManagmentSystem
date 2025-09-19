package com.project.hostelmamagmentsystem.controller;

import com.project.hostelmamagmentsystem.model.entity.User;
import com.project.hostelmamagmentsystem.model.request.UserRequest;
import com.project.hostelmamagmentsystem.model.response.UserResponse;
import com.project.hostelmamagmentsystem.service.UserService;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api/user")
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRequest request) {
        User user1 = new User();
        user1.setEmail(request.getEmail());
        user1.setPassword(request.getPassword());
        user1.setRole(request.getRole());
        User userSave = userService.registerUser(user1);

        return UserResponse.builder().id(userSave.getId()).email(userSave.getEmail()).build();
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest request) {
        User user = userService.login(request.getEmail(), request.getPassword()).orElseThrow(() -> new RuntimeException("The code and gmail you write are wrong"));
        return UserResponse.builder().id(user.getId()).email(user.getEmail()).build();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return UserResponse.builder().id(user.getId()).email(user.getEmail()).build();
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        List<User> users = userService.getAllUsers();
        List<UserResponse> responses = new ArrayList<>();
        for (User user : users) {
            responses.add(UserResponse.builder().id(user.getId()).email(user.getEmail()).build());
        }
        return responses;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


}
