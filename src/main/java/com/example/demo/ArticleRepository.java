package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ArticleRepository {

    private HashMap<Long, Article> articles = new HashMap<>();

    public HashMap<Long, Article> findAll() {
        return articles;
    }

}
