package com.binuralk.financetracker.personal_finance_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;

    // This is the relationship!
    // Many Categories can belong to One User.
    @ManyToOne(fetch = FetchType.LAZY) // LAZY = Don't load the User object from the DB unless we ask for it.
    @JoinColumn(name = "user_id") // This specifies the foreign key column in the 'categories' table.
    private User user; // This can be null for default, global categories.

    @Column(nullable = false)
    private String name;

    @Column(length = 7) // For hex color codes like #FF5733
    private String color;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Instant createdAt;


}
