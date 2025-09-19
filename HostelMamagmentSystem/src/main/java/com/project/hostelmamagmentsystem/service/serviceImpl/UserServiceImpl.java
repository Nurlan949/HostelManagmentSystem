package com.project.hostelmamagmentsystem.service.serviceImpl;

import com.project.hostelmamagmentsystem.enums.UserEnum;
import com.project.hostelmamagmentsystem.model.entity.User;
import com.project.hostelmamagmentsystem.repository.UserRepository;
import com.project.hostelmamagmentsystem.service.UserService;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {

        if (user.getRole() == null) {
            user.setRole(UserEnum.STUDENT);
        }
        return userRepository.save(user);
    }

    @Override
    public Optional<User> login(String email, String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            System.out.println("Email or password cannot be null or empty");
            return Optional.empty();
        }
        Optional<User> user1 = userRepository.findByEmail(email).filter(userOptional -> userOptional.getPassword().equals(password));

        user1.ifPresent(user2 ->
        {
            if (user2.getRole() == UserEnum.ADMIN) {
                System.out.println("Admin logged in");

            } else {
                System.out.println("Standard user logged in");
            }
        });
        return user1;

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
