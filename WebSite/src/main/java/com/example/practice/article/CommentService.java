package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.model.Comment;
import com.example.practice.article.repo.ArticleRepository;
import com.example.practice.article.repo.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentService(ArticleRepository articleRepository, CommentRepository commentRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
    }

    public Comment create(Long articleId, String content, String password) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        Comment comment = new Comment(content, password, article);
        return commentRepository.save(comment);
    }

    public Comment readOne(Long articleId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        if (!comment.getArticle().getId().equals(articleId)) {
            throw new RuntimeException("Invalid comment ID");
        }
        return comment;
    }

    public void delete(Long commentId, String password) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        if (comment.getPassword().equals(password)) {
            commentRepository.deleteById(commentId);
        }
        }


}
