package com.example.practice.article.repo;

import com.example.practice.article.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository
        extends JpaRepository<Comment, Long> {}