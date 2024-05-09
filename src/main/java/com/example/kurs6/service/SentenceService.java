package com.example.kurs6.service;

import com.example.kurs6.dto.SentenceDTO;
import com.example.kurs6.entity.Sentence;
import com.example.kurs6.repository.SentenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SentenceService {

    private SentenceRepository sentenceRepository;
    private WordService wordService;

    public Sentence create(SentenceDTO dto){
        Sentence sentence = Sentence.builder()
                .sentence(dto.getSentence())
                .translate(dto.getTranslate())
                .word(wordService.readById(dto.getWordId()))
                .build();
        return sentenceRepository.save(sentence);
    }

    public List<Sentence> readAll(){
        return sentenceRepository.findAll();
    }

    public List<Sentence> readByWordId(Long id){
        return sentenceRepository.findByWordId(id);
    }

    public Sentence update(Sentence sentence){
        return sentenceRepository.save(sentence);
    }

    public void delete(Long id){
        sentenceRepository.deleteById(id);
    }

}
