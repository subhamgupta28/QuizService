package com.subhamgupta.quizservice.service;

import com.subhamgupta.quizservice.dao.QuizDao;
import com.subhamgupta.quizservice.dto.QuestionDto;
import com.subhamgupta.quizservice.dto.QuizDto;
import com.subhamgupta.quizservice.feign.QuizInterface;
import com.subhamgupta.quizservice.mapper.QuestionMapper;
import com.subhamgupta.quizservice.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizDao quizDao;
    private final QuizInterface quizInterface;
    private final QuestionMapper questionMapper;

    public Object createQuiz(QuizDto quizDto) {
        var questionIds = quizInterface.getQuestionsForQuiz(quizDto.getCategory(), quizDto.getLength()).getBody();
        var quiz = Quiz.builder()
                .title(quizDto.getTitle())
                .questionIds(questionIds)
                .build();
        return quizDao.save(quiz);

    }

    public List<QuestionDto> getQuiz(Integer id) {
        var quiz = quizDao.findById(id).orElseThrow();
        return quizInterface.getQuestions(quiz.getQuestionIds()).getBody();
    }
}
