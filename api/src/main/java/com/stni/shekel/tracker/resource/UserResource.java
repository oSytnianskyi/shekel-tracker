package com.stni.shekel.tracker.resource;

import com.stni.shekel.tracker.dto.CurrentUserDto;
import com.stni.shekel.tracker.service.UserService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import lombok.RequiredArgsConstructor;

@Path("/Endpoint.USERS")
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

  @PUT
  @Path("/verify")
  public String verifyUser() {
    return userService.verifyUser();
  }
}
