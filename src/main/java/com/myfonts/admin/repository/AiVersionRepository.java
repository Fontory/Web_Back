package com.myfonts.admin.repository;

import com.myfonts.admin.domain.AdminAiVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AiVersionRepository extends JpaRepository<AdminAiVersion, Long> {
    Optional<AdminAiVersion> findByIsCurrentVersionTrue();
}
