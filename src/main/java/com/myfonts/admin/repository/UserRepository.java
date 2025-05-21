package com.myfonts.admin.repository;

import com.myfonts.admin.domain.User;
import com.myfonts.admin.domain.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByUserIdAndRole(String userId, UserRole role);
}
