package com.example.practice.article.repo;

import com.example.practice.article.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository
        extends JpaRepository<Board, Long> {
}
