package com.stni.shekel.tracker.resource;

import com.stni.shekel.tracker.config.Endpoints;
import com.stni.shekel.tracker.dto.CreateUserDto;
import com.stni.shekel.tracker.dto.CurrentUserDto;
import com.stni.shekel.tracker.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

@Path(Endpoints.USERS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class UserResource {
  private final UserService userService;

  @GET
  @Path("/current")
  public CurrentUserDto getCurrentUser() {
    return userService.getCurrentUser();
  }

  @POST
  public String createUser(CreateUserDto dto) {
    return userService.createUser(dto);
  }
}
