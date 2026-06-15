package com.example.demo.Article;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository {

    private final HashMap<Long, Article> articles = new HashMap<>();

    public HashMap<Long, Article> findAll() {
        return articles;
    }

    public HashMap<Long, Article> findByBoardID(Long boardId) {
        HashMap<Long, Article> filteredArticles = new HashMap<>();

        for (Map.Entry<Long, Article> entry : articles.entrySet()) {
            if (entry.getValue().getBoardId().equals(boardId)) {
                filteredArticles.put(entry.getKey(), entry.getValue());
            }
        }

        return filteredArticles;
    }

}
