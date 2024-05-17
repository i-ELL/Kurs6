package com.example.kurs6.controller;

import com.example.kurs6.dto.WordDTO;
import com.example.kurs6.entity.Word;
import com.example.kurs6.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/words")
public class WordController {

    private final WordService wordService;

    @PostMapping
    public ResponseEntity<Word> create(@RequestBody WordDTO dto){
        return new ResponseEntity<>(wordService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Word>> readAll(){
        return new ResponseEntity<>(wordService.readAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Word> readById(@PathVariable Long id){
        return new ResponseEntity<>(wordService.readById(id), HttpStatus.OK);
    }

    @GetMapping("/word/{word}")
    public ResponseEntity<Word> readByWord(@PathVariable String word){
        return new ResponseEntity<>(wordService.readByWord(word), HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Word>> readByUserId(@PathVariable Long id){
        return new ResponseEntity<>(wordService.readByUserId(id), HttpStatus.OK);
    }
//    @GetMapping("/r")
//    public ResponseEntity<Long> readRandom(){
//        return new ResponseEntity<>(wordService.getRandomId(), HttpStatus.OK);
//    }


    @PutMapping
    public ResponseEntity<Word> update(@RequestBody Word words){
        return new ResponseEntity<>(wordService.update(words), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        wordService.delete(id);
        return HttpStatus.OK;
    }


}
