package com.myfonts.admin.controller;

import com.myfonts.admin.dto.admin.AiVersionListDto;
import com.myfonts.admin.dto.admin.AiVersionRequestDto;
import com.myfonts.admin.dto.admin.AiVersionResponseDto;
import com.myfonts.admin.service.AdminAiVersionService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/ai-versions")
@RequiredArgsConstructor
public class AdminAiVersionController {

    private final AdminAiVersionService aiVersionService;

    @PostMapping
    @Operation(summary = "관리자가 AI 모델 버전명, 설명, 현재 사용 여부을 적어 AI 모델 버전을 업데이트")
    public ResponseEntity<AiVersionResponseDto> createVersion(@RequestBody AiVersionRequestDto request) {
        AiVersionResponseDto response = aiVersionService.createVersion(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    @Operation(summary = "등록되어 있던 AI 모델 버전명과 설명을 조회")
    public ResponseEntity<List<AiVersionListDto>> getAllVersions() {
        List<AiVersionListDto> result = aiVersionService.getAllVersions();
        return ResponseEntity.ok(result);
    }
}
