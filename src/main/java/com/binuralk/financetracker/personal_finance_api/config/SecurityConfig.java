package com.binuralk.financetracker.personal_finance_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //This part is for the password encoder
    //I have imported below two classes
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF using the new lambda DSL
                .csrf(AbstractHttpConfigurer::disable)

                // Configure authorization rules using the new lambda DSL
                .authorizeHttpRequests(auth -> auth
                        // Use AntPathRequestMatcher for clarity and precision
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/api/health")).permitAll()
                        .anyRequest().authenticated()
                        //New registration endpoint for user registration.
                        .requestMatchers("/h2-console/**", "/api/health", "/api/auth/register").permitAll()
                        .anyRequest().authenticated()
                );

        // Disable frameOptions for H2 console compatibility using the new lambda DSL
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        return http.build();
    }
}