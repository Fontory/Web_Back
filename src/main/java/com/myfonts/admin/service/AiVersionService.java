package com.myfonts.admin.service;

import com.myfonts.admin.domain.AiVersion;
import com.myfonts.admin.dto.AiVersionListDto;
import com.myfonts.admin.dto.AiVersionRequestDto;
import com.myfonts.admin.dto.AiVersionResponseDto;
import com.myfonts.admin.repository.AiVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AiVersionService {

    private final AiVersionRepository aiVersionRepository;

    public AiVersionResponseDto createVersion(AiVersionRequestDto dto) {
        try {
            // 현재 운영 중인 버전이 있을 경우, 운영 상태를 false로 초기화
            if (Boolean.TRUE.equals(dto.getIsCurrentVersion())) {
                aiVersionRepository.findByIsCurrentVersionTrue()
                        .ifPresent(current -> {
                            current.setIsCurrentVersion(false);
                            aiVersionRepository.save(current);
                        });
            }

            AiVersion newVersion = AiVersion.builder()
                    .versionName(dto.getVersionName())
                    .description(dto.getDescription())
                    .isCurrentVersion(dto.getIsCurrentVersion())
                    .build();

            aiVersionRepository.save(newVersion);

            return new AiVersionResponseDto(200, "AI 버전 등록 성공");
        } catch (Exception e) {
            return new AiVersionResponseDto(500, "AI 버전 등록 실패: " + e.getMessage());
        }
    }

    public List<AiVersionListDto> getAllVersions() {
        List<AiVersion> versions = aiVersionRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

        return versions.stream()
                .map(version -> AiVersionListDto.builder()
                        .id(version.getId())
                        .versionName(version.getVersionName())
                        .description(version.getDescription())
                        .isCurrentVersion(version.getIsCurrentVersion())
                        .createdAt(version.getCreatedAt())
                        .build())
                .toList();
    }
}
