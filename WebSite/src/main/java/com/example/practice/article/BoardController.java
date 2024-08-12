package com.example.practice.article;

import com.example.practice.article.model.Board;
import com.example.practice.article.repo.BoardRepository;
import com.example.practice.article.repo.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("boards")
public class BoardController {
    private final BoardRepository boardRepository;
    private final ArticleRepository articleRepository;

    public BoardController(BoardRepository boardRepository, ArticleRepository articleRepository) {
        this.boardRepository = boardRepository;
        this.articleRepository = articleRepository;
    }

    @GetMapping
    public String listBoards(Model model) {
        model.addAttribute("boards", boardRepository.findAll());
        return "boards/list";
    }

    @GetMapping("{boardId}")
    public String viewBoard(@PathVariable("boardId") Long boardId, Model model) {
        model.addAttribute("board", boardRepository.findById(boardId).orElse(null));
        model.addAttribute("articles", articleRepository.findByBoardId(boardId));
        return "boards/view";
    }
}
