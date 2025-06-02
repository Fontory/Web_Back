package com.myfonts.admin.dto.admin;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AiVersionRequestDto {
    private String versionName;
    private String description;
    private Boolean isCurrentVersion;
}
