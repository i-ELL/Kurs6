package com.example.kurs6.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //сущность в бд
@Table(name = "Word")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String word;
    private String translate;
    private String img;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
