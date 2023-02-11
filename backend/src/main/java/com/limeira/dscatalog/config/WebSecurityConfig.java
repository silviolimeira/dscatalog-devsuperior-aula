package com.limeira.dscatalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.headers().disable()
			.authorizeHttpRequests(requests -> requests
			.requestMatchers("/**").permitAll()
			);
//				.requestMatchers(HttpMethod.GET, "/", "/**", "/static/**", "/index.html", "/api/users/me").permitAll()
//				.requestMatchers(HttpMethod.POST, "/users", "/console/*").permitAll()
//				.requestMatchers(HttpMethod.PUT, "/users", "/console/*").permitAll()
//				.requestMatchers(HttpMethod.DELETE, "/users", "/console/*").permitAll()
//				.requestMatchers(HttpMethod.GET, "/users/login", "/api/users/{username}", "/api/users/logout",
//						"/api/costumers", "/api/storages")
//				.authenticated().requestMatchers(HttpMethod.POST, "/api/costumers", "/api/storages").authenticated()
//				.requestMatchers(HttpMethod.PUT, "/api/costumers/{id}", "/api/storages/{id}").authenticated()
//				.requestMatchers(HttpMethod.DELETE, "/api/users/{id}", "/api/storages/{id}", "/api/costumers/{id}")
//				.authenticated().anyRequest().denyAll()).httpBasic();
		return http.build();
	}
}