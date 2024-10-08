package com.example.demosecurity.config;




import com.example.demosecurity.service.UserInfoService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.authentication.AuthenticationManager; 
import org.springframework.security.authentication.AuthenticationProvider; 
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration; 
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import org.springframework.security.config.http.SessionCreationPolicy; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.security.web.SecurityFilterChain; 
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; 

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig { 

	

	// User Creation 
	@Bean
	public UserDetailsService userDetailsService() { 
		return new UserInfoService(); 
	} 
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
         http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/admin/**")
                .hasRole("ADMIN")
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/auth/user/**")
                .authenticated().and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
              
    }


	// Configuring HttpSecurity 
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { 
//		return http.csrf().disable() 
//				.authorizeHttpRequests() 
//				.requestMatchers("/auth/welcome", "/auth/addNewUser", "/auth/generateToken").permitAll() 
//				.and() 
//				.authorizeHttpRequests().requestMatchers("/auth/user/**").authenticated() 
//				.and() 
//				.authorizeHttpRequests().requestMatchers("/auth/admin/**").authenticated() 
//				.and() 
//				.sessionManagement() 
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
//				.and() 
//				.authenticationProvider(authenticationProvider()) 
//				.addFilterBefore( authFilter, UsernamePasswordAuthenticationFilter.class) 
//				.build(); 
//	} 
	
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
