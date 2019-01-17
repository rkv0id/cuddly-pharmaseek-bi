package com.dminers.pharmabi.internalprods.controllers;

import com.dminers.pharmabi.internalprods.domain.Article;
import com.dminers.pharmabi.internalprods.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;
    @GetMapping("/articles")
    public List<Article> retrieveAllStudents() {
        return articleRepository.findAll();
    }
}
