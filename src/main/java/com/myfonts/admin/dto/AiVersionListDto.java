package com.myfonts.admin.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiVersionListDto {
    private Long id;
    private String versionName;
    private String description;
    private Boolean isCurrentVersion;
    private LocalDateTime createdAt;
}
