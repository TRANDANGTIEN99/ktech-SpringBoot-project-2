package com.example.practice.article;

import com.example.practice.article.model.Article;
import com.example.practice.article.model.Board;
import com.example.practice.article.repo.ArticleRepository;
import com.example.practice.article.repo.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BoardRepository boardRepository;

    public ArticleService(ArticleRepository articleRepository, BoardRepository boardRepository) {
        this.articleRepository = articleRepository;
        this.boardRepository = boardRepository;
    }

    public Article create(String title, String content, String password, Long boardId) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("Board not found"));
        Article article = new Article(title, content, password, board);
        return articleRepository.save(article);
    }

    public List<Article> readAll() {
        return articleRepository.findAll();
    }

    public Article readOne(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article update(Long id, String title, String content, String password) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isEmpty()) {
            return null;
        }
        Article article = optionalArticle.get();
        if (article.getPassword().equals(password)) {
            article.setTitle(title);
            article.setContent(content);
            return articleRepository.save(article);
        }
        return null;
    }

    public void delete(Long id, String password) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent() && optionalArticle.get().getPassword().equals(password)) {
            articleRepository.deleteById(id);
        }
    }
}
