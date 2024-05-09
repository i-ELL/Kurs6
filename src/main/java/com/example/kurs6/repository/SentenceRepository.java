package com.example.kurs6.repository;


import com.example.kurs6.entity.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    List<Sentence> findByWordId(Long id);

}
