package com.example.demosecurity.config;




 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.authentication.AuthenticationProvider; 
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration; 
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.web.SecurityFilterChain; 
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demosecurity.service.UserInfoService; 

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig { 

	 

	// User Creation 
	@Bean
	public UserDetailsService userDetailsService() { 
		return new UserInfoService(); 
	} 
	 public static final String ADMIN = "ADMIN";
	    public static final String USER = "USER";

	// Configuring HttpSecurity 
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        return http
	                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
	                        .requestMatchers(HttpMethod.GET, "/api/books", "/api/books/**").hasAnyAuthority(ADMIN, USER)
	                        .requestMatchers(HttpMethod.GET, "/api/users/me").hasAnyAuthority(ADMIN, USER)
	                        .requestMatchers("/api/books", "/api/books/**").hasAuthority(ADMIN)
	                        .requestMatchers("/api/users", "/api/users/**").hasAuthority(ADMIN)
	                        .requestMatchers("/public/**", "/auth/**").permitAll()
	                        .requestMatchers("/", "/error", "/csrf", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**").permitAll()
	                        .anyRequest().authenticated())
	                .httpBasic(Customizer.withDefaults())
	                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	                .cors(Customizer.withDefaults())
	                .csrf(AbstractHttpConfigurer::disable)
	                .build();
	    }
	
//	 @Bean
//	    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//	        http.csrf().disable()
//	                .authorizeHttpRequests((authorize) -> {
//	                    authorize.anyRequest().authenticated();
//	                }).httpBasic(Customizer.withDefaults());
//	        return http.build();
//	    }
	
	
	// Password Encoding 
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); 
	} 
	

	@Bean
	public AuthenticationProvider authenticationProvider() { 
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); 
		authenticationProvider.setUserDetailsService(userDetailsService()); 
		authenticationProvider.setPasswordEncoder(passwordEncoder()); 
		return authenticationProvider; 
	} 

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception { 
		return config.getAuthenticationManager(); 
	} 


} 
