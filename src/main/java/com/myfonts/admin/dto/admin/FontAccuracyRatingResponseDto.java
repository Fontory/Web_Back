package com.myfonts.admin.dto.admin;

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
    private String handwritingFolderPath; //추가
}