package com.myfonts.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminLoginRequest {
    private String userId;
    private String password;
}
