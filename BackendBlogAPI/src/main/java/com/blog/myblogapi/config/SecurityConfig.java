package com.blog.myblogapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private UserDetailsService userDetailsService;
    
    public static final String[] PUBLIC_URL= {
    		"/api/auth/**" ,
    		"/v3/api-docs/**", 
    		"/swagger-ui/**",
    		"/swagger-resources/**" ,
    		"/swagger-ui/**" ,
    		"/webjars/**"
    };

	/*
	 * @Bean public SecurityFilterChain securityFilterChain(HttpSecurity http)
	 * throws Exception {
	 *//*
		 * http .csrf().disable() .authorizeHttpRequests((authorize) -> authorize
		 * .requestMatchers(PUBLIC_URL).permitAll()
		 * 
		 * .requestMatchers(HttpMethod.GET).permitAll() .anyRequest().authenticated()
		 * 
		 * )
		 * .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 * // Use stateless session
		 * 
		 * http.addFilterBefore(jwtRequestFilter,
		 * UsernamePasswordAuthenticationFilter.class);
		 * 
		 * return http.build();
		 */
    	

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests()
                .requestMatchers(PUBLIC_URL).permitAll()
                .anyRequest().authenticated();
        return http.build();
    }
   

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
