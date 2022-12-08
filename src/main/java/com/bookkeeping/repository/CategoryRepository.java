package com.bookkeeping.repository;

import com.bookkeeping.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findAllByUserId(Long id);
}
