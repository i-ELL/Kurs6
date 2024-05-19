package com.example.kurs6.repository;

import com.example.kurs6.entity.User;
import com.example.kurs6.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    List<Word> findByUserId(Long id);
    Word findByWord(String word);
}


