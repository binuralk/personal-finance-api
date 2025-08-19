package com.binuralk.financetracker.personal_finance_api.repository;

import com.binuralk.financetracker.personal_finance_api.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, UUID> {


}