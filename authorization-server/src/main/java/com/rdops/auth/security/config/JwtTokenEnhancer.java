package com.rdops.auth.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
public class JwtTokenEnhancer {
	private static final String SIGNING_KEY = "s1f41234pwqdqkl4l12ghg9853123sd";

	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(SIGNING_KEY);
		return jwtAccessTokenConverter;
	}

}
