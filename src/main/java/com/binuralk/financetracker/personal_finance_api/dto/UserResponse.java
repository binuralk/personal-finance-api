package com.binuralk.financetracker.personal_finance_api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder

public class UserResponse {

    private UUID id;
    private String email;
    private String fullName;
    private Instant createdAt;

}
