package com.example.kurs6.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //сущность в бд
@Table(name = "TestQuestion")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "translateTrue")
    private Word word1;

    @ManyToOne
    @JoinColumn(name = "translateFalse1")
    private Word word2;

    @ManyToOne
    @JoinColumn(name = "translateFalse2")
    private Word word3;

    @ManyToOne
    @JoinColumn(name = "translateFalse3")
    private Word word4;
}
