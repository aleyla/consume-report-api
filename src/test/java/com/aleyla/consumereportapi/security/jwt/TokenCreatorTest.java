package com.aleyla.consumereportapi.security.jwt;

import com.aleyla.consumereportapi.enums.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.util.ReflectionTestUtils;

import java.security.Key;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

class TokenCreatorTest {

    private static final long ONE_MINUTE = 60000;
    private Key key;
    private TokenCreator tokenCreator;

    @BeforeEach
    public void setup() {
        tokenCreator = new TokenCreator();
        key = Keys.hmacShaKeyFor(Decoders.BASE64
                                         .decode("TCB2PThHWnhmQG51LFE8Og==MTQoZD0kYg==TiRbNlBNdThCJHElSkc=REZCVEZlbD5oMzxDNGQmZi9nYns3VVJ9OEo=IEQ5fHM6TWg="));

        ReflectionTestUtils.setField(tokenCreator, "key", key);
        ReflectionTestUtils.setField(tokenCreator, "tokenValidityInMilliseconds", ONE_MINUTE);
    }

    @Test
    public void validate_false_when_JWT_xxpired() {
        ReflectionTestUtils.setField(tokenCreator, "tokenValidityInMilliseconds", -ONE_MINUTE);
        Authentication authentication = createAuthentication();
        String token = tokenCreator.createToken(authentication, false);
        boolean isTokenValid = tokenCreator.validateToken(token);
        assertThat(isTokenValid).isEqualTo(false);
    }

    private Authentication createAuthentication() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(Role.ANONYMOUS.name()));
        return new UsernamePasswordAuthenticationToken("ANONYMOUS", "ANONYMOUS", authorities);
    }

    @Test
    public void validate_false_when_JWT_invalid_signature() {
        boolean isTokenValid = tokenCreator.validateToken(createTokenWithInvalidSignature());
        assertThat(isTokenValid).isEqualTo(false);
    }

    private String createTokenWithInvalidSignature() {
        Key otherKey = Keys.hmacShaKeyFor(Decoders.BASE64
                                                  .decode("QlwiaSkwKXY=VHNxWEojYUJoYFc8J3Q4aztMJS5haXNuT1hje1xdWV4+JC0=SGxHVCU2MS4nTC4iWkc6dDdqPjlFNlozLmJ7"));

        return Jwts.builder()
                   .setSubject("ANONYMOUS")
                   .signWith(otherKey, SignatureAlgorithm.HS512)
                   .setExpiration(new Date(new Date().getTime() + ONE_MINUTE))
                   .compact();
    }

}