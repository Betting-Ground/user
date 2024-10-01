package com.bettingground.user.domain.entity;

import com.bettingground.user._common.*;
import com.bettingground.user.domain.*;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.EnumType.*;
import static jakarta.persistence.GenerationType.*;
import static jakarta.persistence.InheritanceType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "users")
@Inheritance(strategy = JOINED)
@Getter
@NoArgsConstructor(access = PROTECTED)
public class User extends BaseEntity {

    private static final String USER_TOKEN_PREFIX = "user_";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String userToken;
    @Column(nullable = false, unique = true, updatable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(STRING)
    private Role role;

    @Builder
    public User(String username, String password, Role role) {
        this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_TOKEN_PREFIX);
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
