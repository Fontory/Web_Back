package com.myfonts.admin.controller;

import com.myfonts.admin.dto.AdminLoginRequest;
import com.myfonts.admin.dto.TokenResponse;
import com.myfonts.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    @Operation(summary = "관리자가 미리 DB에 등록된 id와 password로 로그인")
    public ResponseEntity<?> login(@RequestBody AdminLoginRequest request) {
        String token = adminService.login(request.getUserId(), request.getPassword());
        return ResponseEntity.ok(new TokenResponse(token));
    }

    @PostMapping("/logout")
    @Operation(summary = "관리자가 로그아웃, 토큰 삭제 필요")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String authHeader) {
        // 클라이언트가 토큰을 삭제해야 하므로 서버는 안내 메시지만 응답
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("유효하지 않은 요청입니다.");
        }

        return ResponseEntity.ok("로그아웃 처리되었습니다. 토큰을 삭제하세요.");
    }
}
