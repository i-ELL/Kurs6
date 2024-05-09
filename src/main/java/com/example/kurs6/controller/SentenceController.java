package com.example.kurs6.controller;


import com.example.kurs6.dto.SentenceDTO;
import com.example.kurs6.entity.Sentence;

import com.example.kurs6.service.SentenceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/sentences")
public class SentenceController {

    private final SentenceService sentenceService;

    @PostMapping
    public ResponseEntity<Sentence> create(@RequestBody SentenceDTO dto){
        return new ResponseEntity<>(sentenceService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Sentence>> readAll(){
        return new ResponseEntity<>(sentenceService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/word/{id}")
    public ResponseEntity<List<Sentence>> readByWordId(@PathVariable Long id){
        return new ResponseEntity<>(sentenceService.readByWordId(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Sentence> update(@RequestBody Sentence sentence){
        return new ResponseEntity<>(sentenceService.update(sentence), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        sentenceService.delete(id);
        return HttpStatus.OK;
    }
}
