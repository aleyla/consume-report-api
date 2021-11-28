package com.aleyla.consumereportapi.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Role {

    @JsonProperty("admin") ADMIN("ROLE_ADMIN"),

    @JsonProperty("user") USER("ROLE_USER");

    private String roleName;

    private static final Map<String, Role> lookup;

    private GrantedAuthority grantedAuthority;

    static {
        lookup = new HashMap<String, Role>();
        for (Role role : Role.values()) {
            lookup.put(role.getRoleName(), role);
        }
    }

    private Role(String roleName) {
        this.roleName = roleName;
        this.grantedAuthority = new SimpleGrantedAuthority(roleName);
    }

    public String getRoleName() {
        return roleName;
    }

    public Optional<Role> getRoleByName(String roleName) {
        return Optional.ofNullable(lookup.get(roleName));
    }

    public GrantedAuthority getGrantedAuthority() {
        return grantedAuthority;
    }

}
