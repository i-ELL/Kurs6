package com.example.kurs6.controller;

import com.example.kurs6.dto.TestCollectionDTO;
import com.example.kurs6.dto.UserDTO;
import com.example.kurs6.entity.TestCollection;
import com.example.kurs6.entity.TestQuestion;
import com.example.kurs6.entity.User;
import com.example.kurs6.service.TestCollectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/testCollection")
public class TestCollectionController {

    private final TestCollectionService testCollectionService;

    @PostMapping("/{userId}")
    public ResponseEntity<TestCollection> create(@PathVariable Long userId, @RequestBody TestCollectionDTO dto){
        return new ResponseEntity<>(testCollectionService.create(userId, dto), HttpStatus.OK);
    }

    @PostMapping("/auto/{userId}")
    public ResponseEntity<TestCollection> createAuto(@PathVariable Long userId){
        return new ResponseEntity<>(testCollectionService.create(userId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TestCollection>> readAll(){
        return new ResponseEntity<>(testCollectionService.readAll(), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TestCollection>> readByUserId(@PathVariable Long userId){
        return new ResponseEntity<>(testCollectionService.readByUserId(userId), HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        testCollectionService.delete(id);
        return HttpStatus.OK;
    }

}
