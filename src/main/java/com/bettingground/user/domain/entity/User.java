package com.bettingground.user.domain.entity;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

import com.bettingground.user._common.utils.TokenGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private static final String USER_TOKEN_PREFIX = "user_";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String userToken;
    private String username;
    private String password;
    @Enumerated(STRING)
    private Role role;
    private String nickname;

    @Builder
    public User(String username, String password, Role role, String nickname) {
        this.userToken = TokenGenerator.randomCharacterWithPrefix(USER_TOKEN_PREFIX);
        this.username = username;
        this.password = password;
        this.role = role;
        this.nickname = nickname;
    }

    public String updatePassword(String password) {
        this.password = password;
        return this.password;
    }
}
