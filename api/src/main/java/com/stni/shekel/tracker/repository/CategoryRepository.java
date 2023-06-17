package com.stni.shekel.tracker.repository;

import com.stni.shekel.tracker.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
  List<Category> findAllByUserId(Long id);

  Optional<Category> findByIdAndUserId(Long id, Long userId);

  //  @Query("select c from Category c join c.accounts a where a.id = :accountId and c.user.id = :userId and a.user.id = :userId")
  List<Category> findAllByAccountIdAndUserId(
//    @Param("accountId")
    Long accountId,
//    @Param("userId")
    Long userId);
}
