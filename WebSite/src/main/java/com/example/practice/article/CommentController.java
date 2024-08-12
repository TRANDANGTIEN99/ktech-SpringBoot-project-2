package com.example.practice.article;

import com.example.practice.article.model.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("articles/{articleId}/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String create(
            @PathVariable("articleId") Long articleId,
            @RequestParam("content") String content,
            @RequestParam("password") String password,
            Model model
    ) {
        try {
            commentService.create(articleId, content, password);
        } catch (Exception e) {
            model.addAttribute("error", "Failed to create comment: " + e.getMessage());
            return "articles/view.html";
        }
        return "redirect:/articles/" + articleId;
    }

    @PostMapping("{commentId}/delete")
    public String delete(
            @PathVariable("commentId") Long commentId,
            @RequestParam("password") String password,
            Model model
    ) {
        try {
            commentService.delete(commentId, password);
        } catch (Exception e) {
            model.addAttribute("error", "Failed to delete comment: " + e.getMessage());
            return "articles/view.html";
        }
        return "redirect:/articles/" + commentId;
    }
}
