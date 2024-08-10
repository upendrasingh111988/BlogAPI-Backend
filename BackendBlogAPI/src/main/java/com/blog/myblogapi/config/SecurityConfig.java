package com.blog.myblogapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	private UserDetailsServiceConfig userDetailsServiceConfig;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeHttpRequests((authorize)->authorize
				.requestMatchers("/api/allposts**").permitAll()
				.anyRequest()
				.authenticated()).httpBasic();
		return http.build();
		
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Password encoder for encoding passwords
    }
	
	/*
	 * @Bean public InMemoryUserDetailsManager userDetailsService() {
	 * 
	 * UserDetails user = User.builder() .username("Upen")
	 * .password(passwordEncoder().encode("123")) .roles("ADMIN") .build();
	 * 
	 * UserDetails user1 = User.builder() .username("Soumya")
	 * .password(passwordEncoder().encode("1234")) .roles("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceConfig).passwordEncoder(passwordEncoder());
	}
}
