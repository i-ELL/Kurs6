package com.example.kurs6.controller;


import com.example.kurs6.dto.ProductDTO;
import com.example.kurs6.dto.TestAnswerDTO;
import com.example.kurs6.entity.TestAnswer;
import com.example.kurs6.service.TestAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/answers")
public class TestAnswerController {

    private TestAnswerService testAnswerService;

    @PostMapping
    public ResponseEntity<TestAnswer> create(@RequestBody TestAnswerDTO dto){
        return new ResponseEntity<>(testAnswerService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TestAnswer>> readAll(){
        return new ResponseEntity<>(testAnswerService.readAll(), HttpStatus.OK);
    }


}
