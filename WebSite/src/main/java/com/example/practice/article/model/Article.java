package com.example.practice.article.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String content;

    @Setter
    private String password;

    @Setter
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Setter
    private LocalDateTime createdAt;

    public Article() {}

    public Article(String title, String content, String password, Board board) {
        this.title = title;
        this.content = content;
        this.password = password;
        this.board = board;
        this.createdAt = LocalDateTime.now();
    }
}