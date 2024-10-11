package com.bettingground.user._config.security;

import com.bettingground.user.domain.entity.Role;
import com.bettingground.user.domain.entity.User;
import io.jsonwebtoken.Claims;
import java.util.ArrayList;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthDetails implements UserDetails {

    private Long id;
    private String userToken;
    private String username;
    private String password;
    private Role role;

    public static AuthDetails of(User user) {
        return AuthDetails.builder()
            .id(user.getId())
            .userToken(user.getUserToken())
            .username(user.getUsername())
            .password(user.getPassword())
            .build();
    }

    public static AuthDetails of(Claims claims) {
        return AuthDetails.builder()
            .userToken(claims.get("userToken", String.class))
            .build();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> "ROLE_" + role);
        return authorities;
    }
}
