package com.binuralk.financetracker.personal_finance_api.controller;

import com.binuralk.financetracker.personal_finance_api.dto.RegisterRequest;
import com.binuralk.financetracker.personal_finance_api.dto.UserResponse;
import com.binuralk.financetracker.personal_finance_api.model.User;
import com.binuralk.financetracker.personal_finance_api.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")

public class AuthController {

    private final AuthService authService;

    // Inject the AuthService using constructor injection
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        // 1. Delegate the registration logic to the service layer
        User registeredUser = authService.registerUser(registerRequest);

        // 2. Map the User entity to a UserResponse DTO
        UserResponse response = UserResponse.builder()
                .id(registeredUser.getId())
                .email(registeredUser.getEmail())
                .fullName(registeredUser.getFullName())
                .createdAt(registeredUser.getCreatedAt())
                .build();

        // 3. Return the response with a 201 CREATED status code
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
