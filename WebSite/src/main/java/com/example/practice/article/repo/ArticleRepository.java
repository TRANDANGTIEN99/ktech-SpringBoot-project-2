package com.example.practice.article.repo;

import com.example.practice.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository
        extends JpaRepository<Article, Long> {}