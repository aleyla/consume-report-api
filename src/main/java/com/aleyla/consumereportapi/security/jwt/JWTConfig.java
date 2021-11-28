package com.aleyla.consumereportapi.security.jwt;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private TokenCreator tokenCreator;

    public JWTConfig(TokenCreator tokenCreator) {
        this.tokenCreator = tokenCreator;
    }

    @Override
    public void configure(HttpSecurity http) {
        JWTFilter customFilter = new JWTFilter(tokenCreator);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
