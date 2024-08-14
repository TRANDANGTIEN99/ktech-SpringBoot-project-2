package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.model.Comment;
import com.example.practice.article.repo.ArticleRepository;
import com.example.practice.article.repo.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public void addComment(Long articleId, String content, String password) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        Comment comment = new Comment(content, password, article);
        commentRepository.save(comment);
    }

    public void deleteComment(Long commentId, String password) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        if (comment.getPassword().equals(password)) {
            commentRepository.delete(comment);
        } else {
            throw new RuntimeException("Incorrect password");
        }
    }
}
