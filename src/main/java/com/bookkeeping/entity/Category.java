package com.bookkeeping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@RegisterForReflection
@Table(name = "category", schema = "public")
public class Category {

  @Id
  @GeneratedValue(generator = "category_id_seq_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "category_id_seq_gen", sequenceName = "category_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
  private User user;

  @Setter(AccessLevel.NONE)
  @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
  private List<Transaction> transactions = new ArrayList<>();

  @ManyToMany(mappedBy = "categories")
  private List<Account> accounts = new ArrayList<>();

  private void setCategories(List<Transaction> transactions) {
    for (Transaction transaction : transactions) {
      transaction.setCategory(this);
    }
    this.transactions.clear();
    this.transactions.addAll(transactions);
  }
}
