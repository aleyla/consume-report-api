package com.aleyla.consumereportapi.security;

import com.aleyla.consumereportapi.entity.UserEntity;
import com.aleyla.consumereportapi.enums.ExceptionCode;
import com.aleyla.consumereportapi.exception.ConsumeReportApiException;
import com.aleyla.consumereportapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        log.debug("Authenticating {}", email);
        UserEntity userEntity = userRepository.findByEmail(email)
                                              .orElseThrow(new ConsumeReportApiException("User not found", ExceptionCode.BAD_REQUEST_ERROR));
        return createSpringSecurityUser(userEntity);
    }


    private org.springframework.security.core.userdetails.User createSpringSecurityUser(UserEntity user) {
        List<GrantedAuthority> grantedAuthorities = Arrays.asList(user.getRole().getGrantedAuthority());
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                                                                      user.getPassword(),
                                                                      grantedAuthorities);
    }
}
