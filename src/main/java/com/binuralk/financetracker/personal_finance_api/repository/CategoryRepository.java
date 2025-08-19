package com.binuralk.financetracker.personal_finance_api.repository;

import com.binuralk.financetracker.personal_finance_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

    // We can add custom query methods here if needed.
    // For example, to find categories by user ID:
    // List<Category> findByUserId(UUID userId);
}