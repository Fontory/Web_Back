package com.myfonts.admin.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FontAccuracySummaryResponse {

    private String adminId;
    private Float averageAccuracy;
    private Float averageRating;
    private List<FontAccuracyRatingResponseDto> fonts;
    private Integer status;
}
