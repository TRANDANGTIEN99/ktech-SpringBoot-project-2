package com.example.practice.article.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Entity
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "board")
    private List<Article> articles;

    public Board() {}

    public Board(String name) {
        this.name = name;
    }
}
