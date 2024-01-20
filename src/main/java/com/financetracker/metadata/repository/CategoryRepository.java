package com.financetracker.metadata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financetracker.metadata.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
