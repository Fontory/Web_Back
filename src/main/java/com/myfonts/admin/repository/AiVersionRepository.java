package com.myfonts.admin.repository;

import com.myfonts.admin.domain.AiVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AiVersionRepository extends JpaRepository<AiVersion, Long> {
    Optional<AiVersion> findByIsCurrentVersionTrue();
}
