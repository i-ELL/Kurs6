package com.example.kurs6.service;

import com.example.kurs6.dto.TestAnswerDTO;
import com.example.kurs6.entity.TestAnswer;
import com.example.kurs6.entity.TestQuestion;
import com.example.kurs6.repository.TestAnswerRepository;
import com.example.kurs6.repository.TestQuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestAnswerService {

    private TestAnswerRepository testAnswerRepository;
    private TestQuestionService testQuestionService;

    private boolean CorrectAnswer(TestAnswerDTO dto){
        String ans = dto.getTranslateUsers();
        TestQuestion test = testQuestionService.readById(dto.getTestId());
        String right = test.getWord1().getTranslate();
        return ans.equals(right);
    }

    public TestAnswer create(TestAnswerDTO dto){
        TestAnswer testAnswer = TestAnswer.builder()
                .translate(dto.getTranslateUsers())
                .ques(testQuestionService.readById(dto.getTestId()))
                .correct(CorrectAnswer(dto))
                .build();
        return testAnswerRepository.save(testAnswer);
    }

    public List<TestAnswer> readAll(){
        return testAnswerRepository.findAll();
    }

}
