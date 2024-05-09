package com.example.kurs6.repository;

import com.example.kurs6.entity.TestQuestion;
import com.example.kurs6.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Long> {

}
