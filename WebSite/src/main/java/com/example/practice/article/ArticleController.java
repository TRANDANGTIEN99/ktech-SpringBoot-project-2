package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.repo.BoardRepository;
import com.example.practice.article.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("boards/{boardId}/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final BoardRepository boardRepository;

    public ArticleController(ArticleService articleService, BoardRepository boardRepository) {
        this.articleService = articleService;
        this.boardRepository = boardRepository;
    }

    @GetMapping("create")
    public String createView(@PathVariable("boardId") Long boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "articles/create.html";
    }

    @PostMapping("create")
    public String create(
            @PathVariable("boardId") Long boardId,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password
    ) {
        articleService.create(title, content, password, boardId);
        return "redirect:/boards/" + boardId;
    }

    @GetMapping("{articleId}")
    public String view(@PathVariable("articleId") Long articleId, Model model) {
        model.addAttribute("article", articleService.readOne(articleId));
        return "articles/view.html";
    }

    @PostMapping("{articleId}/update")
    public String update(
            @PathVariable("articleId") Long articleId,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            @RequestParam("password") String password
    ) {
        articleService.update(articleId, title, content, password);
        return "redirect:/articles/" + articleId;
    }

    @PostMapping("{articleId}/delete")
    public String delete(
            @PathVariable("articleId") Long articleId,
            @RequestParam("password") String password
    ) {
        articleService.delete(articleId, password);
        return "redirect:/boards";
    }
}
