package com.bookkeeping.resource;

import com.bookkeeping.dto.CurrentUserDto;
import com.bookkeeping.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

import static com.bookkeeping.config.Endpoints.CURRENT_USER;

@Path(CURRENT_USER)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class CurrentUserResource {
  private final UserService userService;

  @GET
  public CurrentUserDto getCurrentUser() {
    return userService.getCurrentUser();
  }
}
