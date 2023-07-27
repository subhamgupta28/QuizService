package com.subhamgupta.quizservice.feign;

import com.subhamgupta.quizservice.dto.QuestionDto;
import com.subhamgupta.quizservice.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    @GetMapping("api/v1/question/generate")
    ResponseEntity<List<Integer>> getQuestionsForQuiz(
            @RequestParam String category,
            @RequestParam Integer length
    );
    @PostMapping("api/v1/question/getQuestions")
    ResponseEntity<List<QuestionDto>> getQuestions(
            @RequestBody List<Integer> questionIds
    );

    @PostMapping("api/v1/question/getScore")
    ResponseEntity<?> getScore(
            @RequestBody List<Response> responses
    );
}
