package com.bettingground.user.domain.repository;

import com.bettingground.user.domain.entity.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Long> {
}
