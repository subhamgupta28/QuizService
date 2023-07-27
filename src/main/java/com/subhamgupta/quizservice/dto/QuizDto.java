package com.subhamgupta.quizservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuizDto {
    String category;
    Integer length;
    String title;
}
