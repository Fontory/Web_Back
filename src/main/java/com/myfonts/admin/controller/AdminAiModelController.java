package com.myfonts.admin.controller;

import com.myfonts.admin.dto.admin.FontAccuracySummaryResponse;
import com.myfonts.admin.service.AdminAiModelService;
import com.myfonts.admin.util.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/aimodel")
@RequiredArgsConstructor
public class AdminAiModelController {

    private final AdminAiModelService aiModelService;
    private final JwtUtil jwtUtil;

    @PostMapping("/accuracy")
    @Operation(summary = "폰트 정확도 및 사용자 평점 목록 조회")
    public ResponseEntity<FontAccuracySummaryResponse> getFontAccuracySummary(
            @RequestHeader("Authorization") String authHeader) {

        // JWT 토큰 파싱 로직은 JwtUtil로 추출한다고 가정
        String token = authHeader.substring(7); // "Bearer " 제거
        String adminId = jwtUtil.validateTokenAndGetUserId(token);

        FontAccuracySummaryResponse response = aiModelService.getFontAccuracySummary(adminId);
        return ResponseEntity.ok(response);
    }
}
