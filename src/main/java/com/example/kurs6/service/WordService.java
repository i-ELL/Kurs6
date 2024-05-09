package com.example.kurs6.service;


import com.example.kurs6.dto.WordDTO;
import com.example.kurs6.entity.User;
import com.example.kurs6.entity.Word;
import com.example.kurs6.repository.WordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WordService {

    private UserService userService;
    private WordRepository wordRepository;

    public Word create(WordDTO dto){
        Word word = Word.builder()
                .word(dto.getWord())
                .translate(dto.getTranslate())
                .img(dto.getImg())
                .user(userService.readById(dto.getUserId()))
                .build();
        return wordRepository.save(word);
    }
    public Word readById(Long id){
        return wordRepository.findById(id).orElseThrow( ()-> new RuntimeException("Word not found " + id));
    }
    public List<Long> getAllWordsIds() {
        List<Word> tests = wordRepository.findAll();
        return tests.stream().map(Word::getId).collect(Collectors.toList());
    }
    public Long getRandomId() {
        List<Long> ids = getAllWordsIds();
        Random random = new Random();
        int randomIndex = random.nextInt(ids.size());
        return ids.get(randomIndex);
    }

    public List<Word> readAll(){
        return wordRepository.findAll();
    }

    public List<Word> readByUserId(Long id){
        return wordRepository.findByUserId(id);
    }

    public Word update(Word word){
        return wordRepository.save(word);
    }

    public void delete(Long id){
        wordRepository.deleteById(id);
    }




}
