package com.binuralk.financetracker.personal_finance_api.repository;

import com.binuralk.financetracker.personal_finance_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
    //I have imported the optional class here.
}