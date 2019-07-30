package br.com.carlettisolucoes.csiauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import br.com.carlettisolucoes.csiauth.client.ClientService;

@Configuration
public class OAuthConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private ClientService clientService;

	private String clientid = "cliid";
	
	private String clientSecret = "$2a$12$OQd9Y9Q33NQOIjqaS0G/t.vY9o.bYGyDrbuVmdeeWcZbKFN1sVV56";

	private String privateKey = "MIIEowIBAAKCAQEAw695ILJfMtH9Sil2BOenE7cPBrBcqg8drXnX6Pd+iG/pFH2D"
			+ "W61+D/P4jJ2rc8drZA4AcSJufmOI1DLGjabX2NqDzH8aEOrHd0Sgb0GXbf+9rRW0"
			+ "SzMvIumBbpAtyJAsDHOHEa+QUhhR6N0wXYHesG8Lx8tHklMrAYLq2sS6xIdIaUTL"
			+ "zkrJMIK//MF4wO7lS3pEbmInjMeXmJduS4jzPiTG9M+dE5ii2CJF3Xq1B1yCCyXY"
			+ "n/CKKSa6Qb5ioJrZRHq863O72cyaGppetw/tvDe6JbesQ48JdOWwkAsA3VPTIHac"
			+ "gNZgqnlFi3WGVVMwJ8BRwzzQGoJ/pL8IasVnGQIDAQABAoIBAFhqMTVnwoGoxWO7"
			+ "xfpDXIcY3+4qw0OHHuahtb8qC/7DabF7YF2MzveQSQ3ns27VfJ0xglubrgbnHAyc"
			+ "gH/CEaaGXKSKDRH1sngeBssd/LiTo3TP6K1NjA+fJ374H+eN1Ikvrah9BZ1CJcgs"
			+ "IE0vf5mCIvV70HO5piXBrDF6T9S5bOCOlxjSdewa46ZixA3JGEJA7EYoxvMKggU3"
			+ "FXqlCMOSG+ajNJqOqbDr1Sy+Yi7/+vGOsUR5S0JMemqgotIq0shaUeYmB2DRrutp"
			+ "/AIUzS7y0TFJFacuiNFP7/NsRRri64a//8MnbD6/5eL2pQEsAWlL64o+rovZSkIs"
			+ "gQ8qb80CgYEA5Am4+45KKaN7qQYSVjW6tzbFDrughQkQkyHry1zvQtRXPTq3gRcs"
			+ "m+C6mmXlWg0u/qEQMJ4oKJriLt3serlMdtdv7K989SWxcGK0VqwjTKQjKp3s6/H5"
			+ "5FrICqX8L4Hkhu5TjXOUD9SR4JnLTCmYfMCu2Tx757WDEPf+1ZcnpXMCgYEA264u"
			+ "VVfKM9LpDr1KyJeFtMGogUsSPDtf5ZfVXKoODZsZqmZ1ElTEc1llfYUx9Z1m9naU"
			+ "lNjkxC+3AzTDK5B95nUf9T3FgFS83pR82O7hU9COfqLpC549dEuoAePUzWekUz6m"
			+ "p7qW/FecMNkJxKnkXeNTg8OW7Wd/ax4V+f6P/kMCgYEAlYv2vyoiYsou17r+nYDg"
			+ "8TQ+6RmM/JHkR8lQHG7XDem5SJNQMp1jCNrJJWY7keHhduVje67MwUxJlti9NAJ/"
			+ "LdS9NugjN5W/lud0Qv7iq2ldEp68+EMZUXNjivAtwW4a045KRxKMABG0lSnm1AzX"
			+ "TsECKb7rtxonWSJ6AdL+EhcCgYBIGSmBvvdQ/OaafMu/e+NZCLoJ/R52ADKgAq32"
			+ "5KUKGB5bS5cetg1noi5p/L4B03AIcbCgDXM/ZD2XYsivUpPPgB9F+MkKLkVyc59p"
			+ "/zSasnch3svHkV6v/Widfi3IYDyRSZ2erOGC3ioX6hOHpQ6bNdGiDB5Luk0aVdx2"
			+ "mPKfSwKBgGga1HV5KI9N++A6fV78l1oWaJvVQPQa9uwUujA1b/HObifxzwnLhoWo"
			+ "DOLOXCccZ6fx+qmiEhb+p+E9tKKV7fPc4b+J728PWj+tVFAz7xytL7D7ZbWMudml"
			+ "L7mdMOkqsDC6/VqlD0jLD89G9rJrOAlsLkbZCwvuVUI/8E0uxL/F";

	private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAw695ILJfMtH9Sil2BOen"
			+ "E7cPBrBcqg8drXnX6Pd+iG/pFH2DW61+D/P4jJ2rc8drZA4AcSJufmOI1DLGjabX"
			+ "2NqDzH8aEOrHd0Sgb0GXbf+9rRW0SzMvIumBbpAtyJAsDHOHEa+QUhhR6N0wXYHe"
			+ "sG8Lx8tHklMrAYLq2sS6xIdIaUTLzkrJMIK//MF4wO7lS3pEbmInjMeXmJduS4jz"
			+ "PiTG9M+dE5ii2CJF3Xq1B1yCCyXYn/CKKSa6Qb5ioJrZRHq863O72cyaGppetw/t"
			+ "vDe6JbesQ48JdOWwkAsA3VPTIHacgNZgqnlFi3WGVVMwJ8BRwzzQGoJ/pL8IasVn" + "GQIDAQAB";

	private int accessTokenValiditySeconds = 60000;

	private String[] authorizedGrantedTypes = { "password", "refresh_token" };

	private String[] scopes = { "read", "write" };

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Bean
	public JwtAccessTokenConverter tokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey(privateKey);
		// converter.setVerifierKey(publicKey);
		return converter;
	}

	@Bean
	public JwtTokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(tokenEnhancer());
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		super.configure(security);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(clientService);
		// clients.inMemory().withClient(clientid).secret(clientSecret).scopes(scopes)
		// .authorizedGrantTypes(authorizedGrantedTypes).accessTokenValiditySeconds(accessTokenValiditySeconds);
	}

}
