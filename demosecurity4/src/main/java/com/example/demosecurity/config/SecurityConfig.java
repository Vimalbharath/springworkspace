package com.example.demosecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demosecurity.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers("/public").permitAll() // Allow access to public resources
                .requestMatchers("/admin/**").hasRole("ADMIN") // Admin-only endpoints
                .requestMatchers("/captain/**").hasRole("CAPTAIN") // Captain-only endpoints
                .anyRequest().authenticated() // All other requests require authentication
                .and()
            .formLogin() // Enable form login
                .loginPage("/login") // Login page URL
                .defaultSuccessUrl("/home") // Redirect after successful login
                .permitAll() // Allow everyone to access the login page
                .and()
            .logout() // Enable logout
                .logoutUrl("/logout") // Logout URL
                .permitAll(); // Allow everyone to access logout
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder); // Use the password encoder
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}