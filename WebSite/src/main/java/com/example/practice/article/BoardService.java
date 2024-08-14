package com.example.practice.article;

import com.example.practice.article.model.Board;
import com.example.practice.article.repo.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<Board> readAll() {
        return boardRepository.findAll();
    }

    public Board readOne(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }
}