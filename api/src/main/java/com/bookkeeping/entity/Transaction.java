package com.bookkeeping.entity;

import com.bookkeeping.meta.TransactionType;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@RegisterForReflection
@Table(name = "transaction", schema = "public")
public class Transaction {

  @Id
  @GeneratedValue(generator = "transaction_id_seq_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "transaction_id_seq_gen", sequenceName = "transaction_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "amount", nullable = false)
  private BigDecimal amount;

  @Column(name = "type", nullable = false)
  @Enumerated(EnumType.STRING)
  private TransactionType type;

  @JoinColumn(name = "category_id")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Category category;

  @JoinColumn(name = "user_id")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private User user;

  @JoinColumn(name = "account_id")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Account account;
}
