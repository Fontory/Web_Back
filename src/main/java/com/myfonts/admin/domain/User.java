package com.myfonts.admin.domain;

import com.myfonts.admin.domain.enums.UserRole;
import com.myfonts.admin.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, length = 30)
    private String userId;  // adminId로 로그인

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false, length = 50)
    private String nickname;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Convert(converter = UserRoleConverter.class)
    @Column(nullable = false)
    private UserRole role; //관리자는 ADMIN

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Convert(converter = UserStatusConverter.class)
    @Column(nullable = false)
    private UserStatus status;
}
