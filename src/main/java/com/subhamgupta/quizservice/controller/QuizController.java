package com.subhamgupta.quizservice.controller;

import com.subhamgupta.quizservice.dto.QuizDto;
import com.subhamgupta.quizservice.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("create")
    public ResponseEntity<?> createQuiz(
            @RequestBody QuizDto quizDto
    ) {
        return ResponseEntity.ok(quizService.createQuiz(quizDto));
    }

    @GetMapping("getQuiz/{id}")
    public ResponseEntity<?> getQuiz(
            @PathVariable Integer id
    ) {
        return ResponseEntity.ok(quizService.getQuiz(id));

    }
}
