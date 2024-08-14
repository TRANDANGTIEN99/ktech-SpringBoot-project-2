package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.model.Board;
import com.example.practice.article.repo.ArticleRepository;
import com.example.practice.article.repo.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

    public ArticleService(ArticleRepository articleRepository, BoardRepository boardRepository) {
        this.articleRepository = articleRepository;
        this.boardRepository = boardRepository;
    }

    public Article create(String title, String content, String password, Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
        Article article = new Article(title, content, password, board);
        return articleRepository.save(article);
    }

    public List<Article> readByBoardId(Long boardId) {
        return articleRepository.findByBoardIdOrderByCreatedAtDesc(boardId);
    }

    public Article readOne(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public void update(Long id, String title, String content, String password) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        if (article.getPassword().equals(password)) {
            article.setTitle(title);
            article.setContent(content);
            articleRepository.save(article);
        } else {
            throw new RuntimeException("Incorrect password");
        }
    }

    public void delete(Long id, String password) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
        if (article.getPassword().equals(password)) {
            articleRepository.delete(article);
        } else {
            throw new RuntimeException("Incorrect password");
        }
    }
}
