package com.myfonts.admin.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_versions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AiVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "version_name", nullable = false, unique = true)
    private String versionName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_current_version", nullable = false)
    private Boolean isCurrentVersion;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
