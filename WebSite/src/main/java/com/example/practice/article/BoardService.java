package com.example.practice.article;

import com.example.practice.article.model.Board;
import com.example.practice.article.repo.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // Tạo mới một Board
    public Board create(String name) {
        Board board = new Board(name);
        return boardRepository.save(board);
    }

    // Đọc tất cả các Board
    public List<Board> readAll() {
        return boardRepository.findAll();
    }

    // Đọc một Board theo ID
    public Board readOne(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
    }

    // Cập nhật tên của Board
    public Board update(Long id, String name) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if (optionalBoard.isPresent()) {
            Board board = optionalBoard.get();
            board.setName(name);
            return boardRepository.save(board);
        } else {
            throw new RuntimeException("Board not found");
        }
    }

    // Xóa một Board theo ID
    public void delete(Long id) {
        if (boardRepository.existsById(id)) {
            boardRepository.deleteById(id);
        } else {
            throw new RuntimeException("Board not found");
        }
    }
}
