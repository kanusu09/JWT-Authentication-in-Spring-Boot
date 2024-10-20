
package com.jwt.config;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MyConfig {



        @Bean
        public UserDetailsService userDetailsService() {
            UserDetails userDetails = User.builder().
                    username("pradeep")
                    .password(passwordEncoder().encode("12345")).roles("ADMIN").username("sahdev").password(passwordEncoder().encode("123")).roles("USER").
                    build();
            return new InMemoryUserDetailsManager(userDetails);
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
            return builder.getAuthenticationManager();
        }
    }





