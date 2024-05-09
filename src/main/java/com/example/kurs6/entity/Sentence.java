package com.example.kurs6.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sentence")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String sentence;
    private String translate;

    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word word;
}
