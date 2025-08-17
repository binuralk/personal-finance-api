package com.binuralk.financetracker.personal_finance_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data // Lombok: Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: Generates a no-argument constructor (required by JPA)
@AllArgsConstructor // Lombok: Generates a constructor with all arguments
@Builder // Lombok: Implements the Builder design pattern for easy object creation
@Entity // JPA: This is the most important annotation. It marks this class as a database entity.
@Table(name = "app_users") // Specifies the table name. "user" is often a reserved keyword in SQL.


public class User {

    @Id // JPA: Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.UUID) // Instructs the DB to automatically generate a unique UUID
    private UUID id;

    @Column(nullable = false, unique = true) // DB constraint: cannot be null and must be unique
    private String email;

    @Column(name = "password_hash", nullable = false) // Maps to a specific column name
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @CreationTimestamp // Hibernate: Automatically sets this field to the current time when a user is created
    @Column(name = "created_at", updatable = false) // DB constraint: cannot be updated after creation
    private Instant createdAt;

}
