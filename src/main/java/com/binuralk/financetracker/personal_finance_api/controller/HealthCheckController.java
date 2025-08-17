package com.binuralk.financetracker.personal_finance_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/api/health")
    public String checkHealth() {
        return "Server is up and running!";
    }
}