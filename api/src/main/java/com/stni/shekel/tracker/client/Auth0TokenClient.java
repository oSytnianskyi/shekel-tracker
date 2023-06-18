package com.stni.shekel.tracker.client;

import com.stni.shekel.tracker.client.dto.Auth0TokenDto;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@RegisterRestClient(configKey = "auth0-token-api")
public interface Auth0TokenClient {

  @POST
  Auth0TokenDto getToken(String tokenFetchParams);
}
