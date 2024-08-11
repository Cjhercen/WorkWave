package com.workwave.dto;

import java.util.Set;

import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;

public class CreateClientDto {

	private String clientId;

	private String clientSecret;

	private Set<ClientAuthenticationMethod> authenticationMethods;

	private Set<AuthorizationGrantType> authorizationGrantTypes;

	private Set<String> redirectUris;

	private Set<String> scopes;

	private boolean requireProofKey;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Set<ClientAuthenticationMethod> getAuthenticationMethods() {
		return authenticationMethods;
	}

	public void setAuthenticationMethods(Set<ClientAuthenticationMethod> authenticationMethods) {
		this.authenticationMethods = authenticationMethods;
	}

	public Set<AuthorizationGrantType> getAuthorizationGrantTypes() {
		return authorizationGrantTypes;
	}

	public void setAuthorizationGrantTypes(Set<AuthorizationGrantType> authorizationGrantTypes) {
		this.authorizationGrantTypes = authorizationGrantTypes;
	}

	public Set<String> getRedirectUris() {
		return redirectUris;
	}

	public void setRedirectUris(Set<String> redirectUris) {
		this.redirectUris = redirectUris;
	}

	public Set<String> getScopes() {
		return scopes;
	}

	public void setScopes(Set<String> scopes) {
		this.scopes = scopes;
	}

	public boolean isRequireProofKey() {
		return requireProofKey;
	}

	public void setRequireProofKey(boolean requireProofKey) {
		this.requireProofKey = requireProofKey;
	}

}
