package com.example.kurs6.service;

import com.example.kurs6.dto.TestCollectionDTO;
import com.example.kurs6.entity.TestCollection;
import com.example.kurs6.entity.TestQuestion;
import com.example.kurs6.entity.User;
import com.example.kurs6.repository.TestCollectionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TestCollectionService {

    private TestCollectionRepository testCollectionRepository;
    private  TestQuestionService testQuestionService;
    private WordService wordService;



    public TestCollection create(Long userId){
        List<TestQuestion> tqs = new ArrayList<>();

        int n  = wordService.readByUserId(userId).size();
        if (n > 5)
            n = 5;
        for (int i = 0; i < n; i++) {
            tqs.add(testQuestionService.create(userId));
        }
        TestCollection testCollection = TestCollection.builder()
                .tests(tqs)
                .count(n)
                .userId(userId)
                .build();
        return testCollectionRepository.save(testCollection);
    }

    public TestCollection create(Long userId, TestCollectionDTO dto){
        List<TestQuestion> tqs = new ArrayList<>();

        int n  = wordService.readByUserId(userId).size();
        int userN = dto.getCount();

        if (userN <= n) {
            for (int i = 0; i < userN; i++) {
                tqs.add(testQuestionService.create(userId));
            }
        }
        TestCollection testCollection = TestCollection.builder()
                .tests(tqs)
                .count(userN)
                .userId(userId)
                .build();
        return testCollectionRepository.save(testCollection);
    }

    public List<TestCollection> readAll(){
        return testCollectionRepository.findAll();
    }

    public List<TestCollection> readByUserId(Long userId){
        return testCollectionRepository.findByUserId(userId);
    }

//    public TestCollection readById(Long id){
//        return userRepository.findById(id).orElseThrow( ()-> new RuntimeException("User not found " + id));
//    }


    public TestCollection update(TestCollection testCollection){
        return testCollectionRepository.save(testCollection);
    }

    public void delete(Long id){
        testCollectionRepository.deleteById(id);
    }


}
