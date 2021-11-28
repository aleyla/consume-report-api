package com.aleyla.consumereportapi.configuration;


import com.aleyla.consumereportapi.security.jwt.JWTConfig;
import com.aleyla.consumereportapi.security.jwt.TokenCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenCreator tokenCreator;

    private final CorsFilter corsFilter;

    public SecurityConfig(TokenCreator tokenCreator, CorsFilter corsFilter) {
        this.tokenCreator = tokenCreator;
        this.corsFilter = corsFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/api/v3/merchant/user/login").permitAll()
            .antMatchers("/api/v1/consume-report/login").permitAll()
            .antMatchers("/api/**").authenticated()
            .and()
            .apply(securityConfigurerAdapter());
    }

    private JWTConfig securityConfigurerAdapter() {
        return new JWTConfig(tokenCreator);
    }
}
