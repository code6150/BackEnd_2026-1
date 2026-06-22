package com.example.demo.Article;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleRepository {

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

    public List<Article> findAll() {

        String sql = "SELECT * FROM article";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Article article = new Article();

            article.setId(rs.getLong("id"));
            article.setMemberId(rs.getLong("author_id"));
            article.setBoardId(rs.getLong("board_id"));
            article.setTitle(rs.getString("title"));
            article.setDescription(rs.getString("content"));
            article.setLDT(rs.getTimestamp("created_date").toLocalDateTime());
            article.setLastModifiedTime(rs.getTimestamp("modified_date").toLocalDateTime());

            return article;
        });
    }

    public Article findById(Long id) {

        String sql = """
                SELECT *
                FROM article
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    Article article = new Article();

                    article.setId(rs.getLong("id"));
                    article.setMemberId(rs.getLong("author_id"));
                    article.setBoardId(rs.getLong("board_id"));
                    article.setTitle(rs.getString("title"));
                    article.setDescription(rs.getString("content"));
                    article.setLDT(rs.getTimestamp("created_date").toLocalDateTime());
                    article.setLastModifiedTime(rs.getTimestamp("modified_date").toLocalDateTime());

                    return article;
                },
                id
        );
    }

    public List<Article> findByBoardId(Long boardId) {

        String sql = """
                SELECT *
                FROM article
                WHERE board_id = ?
                """;

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> {

                    Article article = new Article();

                    article.setId(rs.getLong("id"));
                    article.setMemberId(rs.getLong("author_id"));
                    article.setBoardId(rs.getLong("board_id"));
                    article.setTitle(rs.getString("title"));
                    article.setDescription(rs.getString("content"));
                    article.setLDT(rs.getTimestamp("created_date").toLocalDateTime());
                    article.setLastModifiedTime(rs.getTimestamp("modified_date").toLocalDateTime());

                    return article;
                },
                boardId
        );
    }

    public void update(Article article) {

        String sql = """
                UPDATE article
                SET title = ?, content = ?
                WHERE id = ?
                """;

        jdbcTemplate.update(
                sql,
                article.getTitle(),
                article.getDescription(),
                article.getId()
        );
    }

    public void delete(Long id) {

        String sql = """
                DELETE FROM article
                WHERE id = ?
                """;

        jdbcTemplate.update(sql, id);
    }
}