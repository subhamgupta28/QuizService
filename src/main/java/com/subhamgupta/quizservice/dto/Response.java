package com.subhamgupta.quizservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Integer id;
    private String response;
}
