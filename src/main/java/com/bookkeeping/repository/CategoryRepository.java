package com.bookkeeping.repository;

import com.bookkeeping.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findAllByUserId(Long id);

  Optional<Category> findByIdAndUserId(Long id, Long userId);

  @Query("select c from Category c join c.accounts a where a.id = :accountId and c.user.id = :userId and a.user.id = :userId")
  List<Category> findAllByAccountIdAndUserId(@Param("accountId") Long accountId, @Param("userId") Long userId);
}
