package com.example.practice.article.repo;

import com.example.practice.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByBoardIdOrderByCreatedAtDesc(Long boardId);
}
