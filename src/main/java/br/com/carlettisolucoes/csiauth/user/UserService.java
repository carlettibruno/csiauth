package br.com.carlettisolucoes.csiauth.user;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private EntityManager em;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Query query = this.em.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username");
		query.setParameter("username", username);
		try {
			UserEntity user = (UserEntity) query.getSingleResult();
			return new UserAuth(user);
		} catch (NoResultException e) {
			return null;
		}
	}

}