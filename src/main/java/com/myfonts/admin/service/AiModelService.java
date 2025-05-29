package com.myfonts.admin.service;

import com.myfonts.admin.domain.Font;
import com.myfonts.admin.dto.FontAccuracyRatingResponseDto;
import com.myfonts.admin.dto.FontAccuracySummaryResponse;
import com.myfonts.admin.repository.FontRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AiModelService {

    private final FontRepository fontRepository;

    public FontAccuracySummaryResponse getFontAccuracySummary(String adminId) {
        List<Font> fonts = fontRepository.findAll();

        String handwritingFolderPath = "/home/t25123/v0.5src/mobile/App_Back/uploads/profiles/uploads/handwriting";  // 경로

        List<FontAccuracyRatingResponseDto> fontDtos = fonts.stream()
                .map(font -> FontAccuracyRatingResponseDto.builder()
                        .fontId(String.valueOf(font.getFontId()))
                        .name(font.getName())
                        .userId(font.getUserId())
                        .accuracy(font.getVectorSimilarity())
                        .rating(font.getCreatorRating() != null ? font.getCreatorRating().floatValue() : null)
                        .handwritingFolderPath(handwritingFolderPath)  // 추가
                        .build())
                .toList();

        double avgAccuracy = fonts.stream()
                .map(Font::getVectorSimilarity)
                .filter(Objects::nonNull)
                .mapToDouble(Float::doubleValue)
                .average()
                .orElse(0.0);

        double avgRating = fonts.stream()
                .map(Font::getCreatorRating)
                .filter(Objects::nonNull)
                .mapToDouble(Byte::doubleValue)
                .average()
                .orElse(0.0);

        return FontAccuracySummaryResponse.builder()
                .adminId(adminId)
                .averageAccuracy((float) avgAccuracy)
                .averageRating((float) avgRating)
                .fonts(fontDtos)
                .status(200)
                .build();
    }


}
