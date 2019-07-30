package br.com.carlettisolucoes.csiauth.client;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class ClientEntity implements Serializable {

	private static final long serialVersionUID = -6610105835080772171L;

	@Id
	@Column(name = "client_id", nullable = false)
	private String clientId;

	@Column(name = "resource_ids")
	private String resourceIds;

	@Column(name = "client_secret", nullable = false)
	private String clientSecret;

	@Column(name = "scope", nullable = false)
	private String scope;

	@Column(name = "authorized_grant_types", nullable = false)
	private String authorizedGrantTypes;

	@Column(name = "authorities")
	private String authorities;

	@Column(name = "access_token_validity", nullable = false)
	private Integer accessTokenValidity;

	@Column(name = "refresh_token_validity", nullable = false)
	private Integer refreshTokenValidity;

	@Column(name = "web_server_redirect_uri")
	private String webServerRedirectUri;

	@Column(name = "name", nullable = false)
	private String name;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public Integer getAccessTokenValidity() {
		return accessTokenValidity;
	}

	public void setAccessTokenValidity(Integer accessTokenValidity) {
		this.accessTokenValidity = accessTokenValidity;
	}

	public Integer getRefreshTokenValidity() {
		return refreshTokenValidity;
	}

	public void setRefreshTokenValidity(Integer refreshTokenValidity) {
		this.refreshTokenValidity = refreshTokenValidity;
	}

	public String getWebServerRedirectUri() {
		return webServerRedirectUri;
	}

	public void setWebServerRedirectUri(String webServerRedirectUri) {
		this.webServerRedirectUri = webServerRedirectUri;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ClientEntity [accessTokenValidity=" + accessTokenValidity + ", authorities=" + authorities
				+ ", authorizedGrantTypes=" + authorizedGrantTypes + ", clientId=" + clientId + ", clientSecret="
				+ clientSecret + ", name=" + name + ", refreshTokenValidity=" + refreshTokenValidity + ", resourceIds="
				+ resourceIds + ", scope=" + scope + ", webServerRedirectUri=" + webServerRedirectUri + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientEntity other = (ClientEntity) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		return true;
	}

}