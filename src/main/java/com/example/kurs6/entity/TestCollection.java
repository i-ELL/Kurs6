package com.example.kurs6.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity //сущность в бд
@Table(name = "TestCollection")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private int count;
    private Long userId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TestQuestion> tests;

}
