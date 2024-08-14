package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards/{boardId}/articles")
public class ArticleController {
    private final ArticleService articleService;
    private final CommentService commentService;

    public ArticleController(ArticleService articleService, CommentService commentService) {
        this.articleService = articleService;
        this.commentService = commentService;
    }

    @GetMapping("/create")
    public String createArticleForm(@PathVariable Long boardId, Model model) {
        model.addAttribute("boardId", boardId);
        return "articles/createArticle"; // Đảm bảo đường dẫn và tên tệp HTML chính xác
    }

    @PostMapping("/create")
    public String createArticle(@PathVariable Long boardId,
                                @RequestParam String title,
                                @RequestParam String content,
                                @RequestParam String password) {
        articleService.create(title, content, password, boardId);
        return "redirect:/boards/" + boardId; // Điều hướng về trang danh sách bài viết của bảng
    }

    @GetMapping("/{articleId}")
    public String viewArticle(@PathVariable Long boardId, @PathVariable Long articleId, Model model) {
        Article article = articleService.readOne(articleId);
        model.addAttribute("article", article);
        return "articles/viewArticle";
    }

    @PostMapping("/{articleId}/update")
    public String updateArticle(@PathVariable Long boardId, @PathVariable Long articleId,
                                @RequestParam String title, @RequestParam String content,
                                @RequestParam String password) {
        articleService.update(articleId, title, content, password);
        return "redirect:/boards/" + boardId + "/articles/" + articleId;
    }

    @PostMapping("/{articleId}/delete")
    public String deleteArticle(@PathVariable Long boardId, @PathVariable Long articleId,
                                @RequestParam String password) {
        articleService.delete(articleId, password);
        return "redirect:/boards/" + boardId;
    }

    @PostMapping("/{articleId}/comments")
    public String addComment(@PathVariable Long articleId, @RequestParam String content,
                             @RequestParam String password) {
        commentService.addComment(articleId, content, password);
        return "redirect:/boards/" + articleService.readOne(articleId).getBoard().getId() + "/articles/" + articleId;
    }

    @PostMapping("/comments/{commentId}/delete")
    public String deleteComment(@PathVariable Long commentId, @RequestParam String password) {
        commentService.deleteComment(commentId, password);
        return "redirect:/boards";
    }
}
