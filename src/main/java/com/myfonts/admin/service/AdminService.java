package com.myfonts.admin.service;

import com.myfonts.admin.domain.User;
import com.myfonts.admin.domain.enums.UserRole;
import com.myfonts.admin.repository.UserRepository;
import com.myfonts.admin.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    //로그인 기능
    public String login(String userId, String rawPassword) {
        User user = userRepository.findByUserIdAndRole(userId, UserRole.ADMIN)
                .orElseThrow(() -> new RuntimeException("관리자 계정이 존재하지 않습니다."));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }

        return jwtUtil.createToken(user.getUserId());
    }

    //로그아웃 기능
    public void logout(String token) {
        System.out.println("로그아웃 요청 받은 토큰: " + token);
    }


}
