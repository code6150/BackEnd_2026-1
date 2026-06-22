package com.example.demo.Article;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleDao {
    private final JdbcTemplate jdbcTemplate;

    public ArticleDao(JdbcTemplate jdbcTemplate) {
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

}
