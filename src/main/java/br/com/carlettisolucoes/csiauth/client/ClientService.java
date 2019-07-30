package br.com.carlettisolucoes.csiauth.client;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientDetailsService {

    @Autowired
    private EntityManager em;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Query query = this.em.createQuery("SELECT c FROM ClientEntity c WHERE c.clientId = :clientId");
        query.setParameter("clientId", clientId);
        try {
            ClientEntity client = (ClientEntity) query.getSingleResult();
            return new ClientAuth(client);
        } catch (NoResultException e) {
            return null;
        }
    }

}
