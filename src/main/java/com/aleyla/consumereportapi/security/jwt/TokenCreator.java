package com.aleyla.consumereportapi.security.jwt;

import com.aleyla.consumereportapi.util.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenCreator implements InitializingBean {

    private static final String AUTHORITIES_KEY = "auth";
    private final Logger log = LoggerFactory.getLogger(TokenCreator.class);
    private Key key;

    private long tokenValidityInMilliseconds;

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes;
        keyBytes = Decoders.BASE64.decode(Constants.BASE64_SECRET);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.tokenValidityInMilliseconds =Constants.TOKEN_VALIDITY_IN_SECOND;
    }

    public String createToken(Authentication authentication, boolean rememberMe) {
        String authorities = authentication.getAuthorities().stream()
                                           .map(GrantedAuthority::getAuthority)
                                           .collect(Collectors.joining(","));

        Date validity = new Date((new Date()).getTime() + this.tokenValidityInMilliseconds);

        return Jwts.builder()
                   .setSubject(authentication.getName())
                   .claim(AUTHORITIES_KEY, authorities)
                   .signWith(key, SignatureAlgorithm.HS512)
                   .setExpiration(validity)
                   .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser()
                            .setSigningKey(key)
                            .parseClaimsJws(token)
                            .getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                      .map(SimpleGrantedAuthority::new)
                      .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            log.info("Invalid JWT token.");
            log.trace("Invalid JWT token trace.", e);
        }
        return false;
    }
}
