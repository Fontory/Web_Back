package com.myfonts.admin.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginRequest {
    private String userId;
    private String password;
}
