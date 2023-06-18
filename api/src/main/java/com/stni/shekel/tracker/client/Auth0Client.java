package com.stni.shekel.tracker.client;

import com.stni.shekel.tracker.client.authorization.Auth0ClientAuthorizationHeaderFactory;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "auth0-m2m-api")
@RegisterClientHeaders(Auth0ClientAuthorizationHeaderFactory.class)
public interface Auth0Client {
}
