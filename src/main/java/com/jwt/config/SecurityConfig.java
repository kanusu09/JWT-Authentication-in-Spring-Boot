package com.jwt.config;

import com.jwt.security.JWTAthenticationEntryPoint;
import com.jwt.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {


    @Autowired
    private JWTAthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

          http.csrf(csrf -> csrf.disable())  // Disable CSRF protection
                .cors(cors -> cors.disable())  // Disable CORS
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/users").authenticated()
                        .requestMatchers("/auth/login").permitAll()  // Allow login endpoint without authentication
                        .anyRequest().authenticated()  // All other endpoints require authentication
                )
                .exceptionHandling(ex -> ex.authenticationEntryPoint(point))  // Handle unauthorized access
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  // Stateless session management
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
