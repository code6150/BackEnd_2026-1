package com.example.demo.Article;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ArticleRepository {

    private final HashMap<Long, Article> articles = new HashMap<>();

    public HashMap<Long, Article> findAll() {
        return articles;
    }

    private final JdbcTemplate jdbcTemplate;

    public ArticleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Article article) {

        String sql = """
            INSERT INTO article(author_id, board_id, title, content)
            VALUES (?, ?, ?, ?)
            """;

        jdbcTemplate.update(
                sql,
                article.getMemberId(),
                article.getBoardId(),
                article.getTitle(),
                article.getDescription()
        );
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
