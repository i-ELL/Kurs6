package com.example.kurs6.controller;


import com.example.kurs6.dto.UserDTO;
import com.example.kurs6.entity.User;
import com.example.kurs6.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO dto){
        return new ResponseEntity<>(userService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> readAll(){
        return new ResponseEntity<>(userService.readAll(), HttpStatus.OK);
    }

//    @GetMapping("/user/{id}")
//    public ResponseEntity<User> readOne(@PathVariable Long id){
//        return new ResponseEntity<>(userService.readOne(id), HttpStatus.OK);
//    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        userService.delete(id);
        return HttpStatus.OK;
    }
}
