package com.algocrafters.app.cookbook.dto;

import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

/**
 * A class serving as a DTO to carry data to/from persistent {@code UserDetailsEntity} objects to the API layer.
 *
 * @author Vitali Tchalov (github/VitaliTch)
 * @author {name}
 *
 * @since 0.1
 */
public record UserDetailsData(
        @Nullable String accountId,
        @Nullable String username,
        @Nullable String password,
        @Nullable Set<GrantedAuthority> authorities,
        boolean accountNonExpired,
        boolean accountNonLocked,
        boolean credentialsNonExpired,
        boolean enabled) {
}
