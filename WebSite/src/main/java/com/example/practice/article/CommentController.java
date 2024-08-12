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
            @RequestParam("password") String password
    ) {
        commentService.create(articleId, content, password);
        return "redirect:/articles/" + articleId;
    }

    @PostMapping("{commentId}/delete")
    public String delete(
            @PathVariable("commentId") Long commentId,
            @RequestParam("password") String password
    ) {
        commentService.delete(commentId, password);
        return "redirect:/articles/" + commentId;
    }
}
