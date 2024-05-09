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

    @PostMapping
    public ResponseEntity<TestQuestion> create(){
        return new ResponseEntity<>(testQuestionService.create(), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TestQuestion>> readAll(){
        return new ResponseEntity<>(testQuestionService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/ra")
    public ResponseEntity<Long> Uniq(){
        return new ResponseEntity<>(testQuestionService.Uniq().get(0), HttpStatus.OK);
    }

}
