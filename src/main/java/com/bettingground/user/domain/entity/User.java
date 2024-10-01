package com.bettingground.user.domain.entity;

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
public abstract class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(nullable = false, unique = true, updatable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(STRING)
    private Role role;

}
