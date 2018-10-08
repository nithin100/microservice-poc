package com.rdops.auth.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	private JwtAccessTokenConverter tokenEnhancer;

	private UserDetailsService userDetailsService;

	private final AuthenticationManager authenticationManager;

	private BCryptPasswordEncoder encoder;

	public AuthorizationServerConfig(JwtAccessTokenConverter tokenEnhancer, UserDetailsService userDetailsService,
			AuthenticationManager authenticationManager, BCryptPasswordEncoder encoder) {
		super();
		this.tokenEnhancer = tokenEnhancer;
		this.userDetailsService = userDetailsService;
		this.authenticationManager = authenticationManager;
		this.encoder = encoder;
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(tokenEnhancer);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clientsDetails) throws Exception {
		//@// @formatter:off
		clientsDetails.inMemory()
			.withClient("client")
			.secret(encoder.encode("secret"))
			.scopes("server")
			.authorizedGrantTypes("client_credentials", "refresh_token")
			.and()
			.withClient("ui")
			.secret(encoder.encode("secret"))
			.authorizedGrantTypes("password", "refresh_token")
			.scopes("read");
		
		// @formatter:on
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.userDetailsService(userDetailsService).accessTokenConverter(tokenEnhancer)
				.authenticationManager(authenticationManager);
		super.configure(endpoints);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.passwordEncoder(encoder);
	}
	
	

}
