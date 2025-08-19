package com.binuralk.financetracker.personal_finance_api.service;

import com.binuralk.financetracker.personal_finance_api.dto.RegisterRequest;
import com.binuralk.financetracker.personal_finance_api.model.User;
import com.binuralk.financetracker.personal_finance_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Marks this class as a Spring service component

public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // --- Dependency Injection via Constructor ---
    // Spring will automatically provide the UserRepository and PasswordEncoder beans.
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional // Ensures the whole method runs in a single database transaction
    public User registerUser(RegisterRequest registerRequest) {
        // Business Rule 1: Check if email already exists
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        // Create a new User entity from the DTO
        User newUser = User.builder()
                .email(registerRequest.getEmail())
                .fullName(registerRequest.getFullName())
                // Business Rule 2: NEVER store plain text passwords. Always hash them.
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        // Save the new user to the database
        return userRepository.save(newUser);
    }

}


