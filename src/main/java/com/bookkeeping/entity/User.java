package com.bookkeeping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "user", schema = "public")
public class User {

  @Id
  @GeneratedValue(generator = "user_id_seq_gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "user_id_seq_gen", sequenceName = "user_id_seq", allocationSize = 1)
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "email")
  private String email;

  @Setter(AccessLevel.NONE)
  @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
  List<Category> categories = new ArrayList<>();

  private void setCategories(List<Category> categories) {
    for (Category category : categories) {
      category.setUser(this);
    }
    this.categories.clear();
    this.categories.addAll(categories);
  }
}
