package com.bookkeeping.repository;

import com.bookkeeping.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  @Query("select c.name from Category c where c.user.id = :id")
  List<String> findAllNamesByUserId(Long id);
}
