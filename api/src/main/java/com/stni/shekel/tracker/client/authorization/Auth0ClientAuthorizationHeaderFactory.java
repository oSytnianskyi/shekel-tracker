package com.stni.shekel.tracker.client.authorization;

import com.stni.shekel.tracker.client.Auth0TokenClient;
import com.stni.shekel.tracker.client.dto.Auth0TokenDto;
import com.stni.shekel.tracker.client.param.Auth0CredentialsParams;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.specimpl.MultivaluedMapImpl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class Auth0ClientAuthorizationHeaderFactory implements ClientHeadersFactory {
  private static final String TOKEN_PARAMETERS_HOLDER = "grant_type=%s&client_id=%s&client_secret=%s&audience=%s";

  @Inject
  Auth0CredentialsParams auth0CredentialsParams;

  @Inject
  @RestClient
  Auth0TokenClient auth0TokenClient;

  @Override
  public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
                                               MultivaluedMap<String, String> clientOutgoingHeaders) {
    String token = getToken();
    MultivaluedMap<String, String> additionalHeaders = new MultivaluedMapImpl<>();
    additionalHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
    return additionalHeaders;
  }

  @CacheResult(cacheName = "auth0-m2m-token")
  String getToken() {
    String tokenFetchParams = getTokenFetchParam();
    Auth0TokenDto tokenDto = auth0TokenClient.getToken(tokenFetchParams);
    return tokenDto.getAccessToken();
  }

  private String getTokenFetchParam() {
    String clientId = auth0CredentialsParams.clientId();
    String audience = auth0CredentialsParams.audience();
    String grandType = auth0CredentialsParams.grandType();
    String clientSecret = auth0CredentialsParams.clientSecret();
    return String.format(TOKEN_PARAMETERS_HOLDER, grandType, clientId, clientSecret, audience);
  }
}
