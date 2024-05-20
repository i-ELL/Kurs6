package com.example.kurs6.service;

import com.example.kurs6.entity.TestQuestion;
import com.example.kurs6.entity.User;
import com.example.kurs6.repository.TestQuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class TestQuestionService {

    private TestQuestionRepository testQuestionRepository;
    private WordService wordService;


    public List<Long> Uniq(Long id){
        List<Long> selectedIds = new ArrayList<>();
        while (selectedIds.size() < 4) {
            Long selectedId = wordService.getRandomId(id);
            if (!selectedIds.contains(selectedId)) {
                selectedIds.add(selectedId);
            }
        }
        return selectedIds;
    }

    public TestQuestion create(Long id){
        List<Long> ids = Uniq(id);
        TestQuestion testQuestion = TestQuestion.builder()
                .word1(wordService.readById(ids.get(0)))
                .word2(wordService.readById(ids.get(1)))
                .word3(wordService.readById(ids.get(2)))
                .word4(wordService.readById(ids.get(3)))
                .build();
        return testQuestionRepository.save(testQuestion);
    }
    public List<TestQuestion> readAll(){
        return testQuestionRepository.findAll();
    }

    public TestQuestion readById(Long id){
        return testQuestionRepository.findById(id).orElseThrow( ()-> new RuntimeException("testQuestion not found " + id));
    }
    public void delete(Long id){
        testQuestionRepository.deleteById(id);
    }
}
