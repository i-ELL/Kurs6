package com.example.kurs6.controller;


import com.example.kurs6.entity.TestQuestion;
import com.example.kurs6.service.TestQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/test")
public class TestQuestionController {

    private final TestQuestionService testQuestionService;

    @PostMapping("/{id}")
    public ResponseEntity<TestQuestion> create(@PathVariable Long id){
        return new ResponseEntity<>(testQuestionService.create(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TestQuestion>> readAll(){
        return new ResponseEntity<>(testQuestionService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/ra/{id}")
    public ResponseEntity<Long> Uniq(@PathVariable Long id){
        return new ResponseEntity<>(testQuestionService.Uniq(id).get(0), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        testQuestionService.delete(id);
        return HttpStatus.OK;
    }

}
