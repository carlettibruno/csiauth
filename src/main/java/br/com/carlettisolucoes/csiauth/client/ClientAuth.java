package br.com.carlettisolucoes.csiauth.client;

import org.springframework.security.oauth2.provider.client.BaseClientDetails;

public class ClientAuth extends BaseClientDetails {

	private static final long serialVersionUID = 7355244611185917189L;

	public ClientAuth(ClientEntity client) {
		super(client.getClientId(), client.getResourceIds(), client.getScope(), client.getAuthorizedGrantTypes(),
				client.getAuthorities(), client.getWebServerRedirectUri());
		this.setClientSecret(client.getClientSecret());
		this.addAdditionalInformation("name", client.getName());
	}

}