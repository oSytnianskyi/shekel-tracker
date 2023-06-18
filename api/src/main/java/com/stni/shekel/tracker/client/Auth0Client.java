package com.stni.shekel.tracker.client;

import com.stni.shekel.tracker.client.authorization.Auth0ClientAuthorizationHeaderFactory;
import com.stni.shekel.tracker.dto.Auth0UserDto;
import com.stni.shekel.tracker.dto.Auth0UserLinkDto;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "auth0-m2m-api")
@RegisterClientHeaders(Auth0ClientAuthorizationHeaderFactory.class)
public interface Auth0Client {

  @GET
  @Path("/users")
  List<Auth0UserDto> getUsersByEmail(@QueryParam("q") String luceneQueryEmail);

  @POST
  @Path("/users/{primaryUserId}/identities")
  void linUsers(@PathParam("primaryUserId") String primaryUserId, @RequestBody Auth0UserLinkDto linkDto);
}
