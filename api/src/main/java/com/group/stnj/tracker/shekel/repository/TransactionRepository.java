package com.group.stnj.tracker.shekel.repository;

import com.group.stnj.tracker.shekel.entity.TransactionEntity;

import java.util.List;

public interface TransactionRepository {
  String saveAll(List<TransactionEntity> entities);
}
