package com.bookkeeping.service.impl;

import com.bookkeeping.service.CurrentUserService;

import javax.enterprise.context.ApplicationScoped;

import lombok.RequiredArgsConstructor;

@ApplicationScoped
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {

  @Override
  public String getCurrentUserEmail() {
    return "currentUser@mail.com";
  }
}
