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

    public List<Long> Uniq(){
        //Random random = new Random();
        List<Long> selectedIds = new ArrayList<>();

        while (selectedIds.size() < 4) {
            Long selectedId = wordService.getRandomId();
            //String selectedId = idList.get(randomIndex);
            if (!selectedIds.contains(selectedId)) {
                selectedIds.add(selectedId);
            }
        }
        return selectedIds;
    }


    public TestQuestion create(){
        List<Long> ids = Uniq();
        TestQuestion testQuestion = TestQuestion.builder()
                .word1(wordService.readById(wordService.getRandomId()))
                .word2(wordService.readById(wordService.getRandomId()))
                .word3(wordService.readById(wordService.getRandomId()))
                .word4(wordService.readById(wordService.getRandomId()))
                .build();
        return testQuestionRepository.save(testQuestion);
    }

    public List<TestQuestion> readAll(){
        return testQuestionRepository.findAll();
    }

    public TestQuestion readById(Long id){
        return testQuestionRepository.findById(id).orElseThrow( ()-> new RuntimeException("testQuestion not found " + id));
    }
}
