package com.aleyla.consumereportapi.enums;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Role {

    ADMIN("ROLE_ADMIN"),

    USER("ROLE_USER"),

    ANONYMOUS("ANONYMOUS");

    private String roleName;

    private static final Map<String, Role> lookup;

    private GrantedAuthority grantedAuthority;

    static {
        lookup = new HashMap<String, Role>();
        for (Role role : Role.values()) {
            lookup.put(role.getRoleName(), role);
        }
    }

    Role(String roleName) {
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
