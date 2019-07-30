package br.com.carlettisolucoes.csiauth.user;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -6610105835080772171L;

	@Id
	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "enabled", nullable = false)
	private Boolean enabled;

	@Column(name = "account_expired", nullable = false)
	private Boolean accountExpired;

	@Column(name = "credentials_expired", nullable = false)
	private Boolean credentialsExpired;

	@Column(name = "account_locked", nullable = false)
	private Boolean accountLocked;

	@Column(name = "granted_authorities", nullable = false)
	private String grantedAuthorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGrantedAuthorities() {
		return grantedAuthorities;
	}

	public List<GrantedAuthority> listGrantedAuthorities() {
		List<GrantedAuthority> gas = Arrays.asList(grantedAuthorities.split(",")).stream().filter(ga -> !ga.isEmpty())
				.map(ga -> new SimpleGrantedAuthority(ga)).collect(Collectors.toList());
		return gas;
	}

	public void setGrantedAuthorities(String grantedAuthorities) {
		this.grantedAuthorities = grantedAuthorities;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getAccountExpired() {
		return accountExpired;
	}

	public void setAccountExpired(Boolean accountExpired) {
		this.accountExpired = accountExpired;
	}

	public Boolean getCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(Boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public Boolean getAccountLocked() {
		return accountLocked;
	}

	public void setAccountLocked(Boolean accountLocked) {
		this.accountLocked = accountLocked;
	}

	@Override
	public String toString() {
		return "UserEntity [accountExpired=" + accountExpired + ", accountLocked=" + accountLocked
				+ ", credentialsExpired=" + credentialsExpired + ", enabled=" + enabled + ", grantedAuthorities="
				+ grantedAuthorities + ", password=" + password + ", username=" + username + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserEntity other = (UserEntity) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}