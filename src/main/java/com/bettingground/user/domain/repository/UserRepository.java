package com.bettingground.user.domain.repository;

import com.bettingground.user.domain.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserToken(String userToken);

    Optional<User> findByUsername(String username);
}
