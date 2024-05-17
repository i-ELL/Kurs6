package com.example.kurs6.repository;

import com.example.kurs6.entity.TestCollection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestCollectionRepository extends JpaRepository<TestCollection, Long> {

    //List<TestCollection> findByUserId(Long userId);


    List<TestCollection> findByUserId(Long userId);
}
