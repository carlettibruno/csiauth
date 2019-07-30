package br.com.carlettisolucoes.csiauth.user;

import org.springframework.security.core.userdetails.User;

public class UserAuth extends User {

	private static final long serialVersionUID = 7355244611185917189L;

	public UserAuth(UserEntity user) {
		super(user.getUsername(), user.getPassword(), user.getEnabled(), !user.getAccountExpired(),
				!user.getCredentialsExpired(), !user.getAccountLocked(), user.listGrantedAuthorities());
	}

}