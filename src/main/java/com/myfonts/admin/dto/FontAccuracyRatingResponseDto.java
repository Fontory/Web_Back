package com.myfonts.admin.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FontAccuracyRatingResponseDto {

    private String fontId;
    private String name;
    private String userId;
    private Float accuracy;  // vectorSimilarity
    private Float rating;    // creatorRating
}