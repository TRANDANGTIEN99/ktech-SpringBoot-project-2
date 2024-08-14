package com.example.practice.article;

import com.example.practice.article.model.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("boards")
public class BoardController {
    private final BoardService boardService;
    private final ArticleService articleService;

    public BoardController(BoardService boardService, ArticleService articleService) {
        this.boardService = boardService;
        this.articleService = articleService;
    }
    @GetMapping
    public String listBoards(Model model) {
        model.addAttribute("boards", boardService.readAll());
        return "boards/listBoards";
    }

    @GetMapping("/{boardId}")
    public String viewBoard(@PathVariable Long boardId, Model model) {
        Board board = boardService.readOne(boardId);
        model.addAttribute("board", board);
        model.addAttribute("articles", articleService.readByBoardId(boardId));
        return "articles/viewBoard";
    }
}