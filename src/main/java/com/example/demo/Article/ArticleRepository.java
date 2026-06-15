package com.example.demo.Article;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ArticleRepository {

    private final HashMap<Long, Article> articles = new HashMap<>();

    public HashMap<Long, Article> findAll() {
        return articles;
    }

}
