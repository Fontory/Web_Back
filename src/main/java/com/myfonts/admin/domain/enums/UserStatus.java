package com.myfonts.admin.domain.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserStatus {
    ACTIVE,
    DORMANT,
    WITHDRAWN;

    @JsonValue
    public String toJson() {
        return this.name().toLowerCase();
    }

    @JsonCreator
    public static UserStatus fromJson(String value) {
        return UserStatus.valueOf(value.toUpperCase());
    }
}
