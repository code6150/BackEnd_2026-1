package com.example.demo.Board;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Board board) {

        String sql = """
                INSERT INTO board(name)
                VALUES (?)
                """;

        jdbcTemplate.update(sql, board.getBoardName());
    }

    public void update(Board board) {

        String sql = """
            UPDATE board
            SET name = ?
            WHERE id = ?
            """;

        jdbcTemplate.update(
                sql,
                board.getBoardName(),
                board.getId()
        );
    }

    public void delete(Long id) {

        String sql = """
            DELETE FROM board
            WHERE id = ?
            """;

        jdbcTemplate.update(sql, id);
    }

    public List<Board> findAll() {

        String sql = "SELECT * FROM board";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Board board = new Board();

            board.setId(rs.getLong("id"));
            board.setBoardName(rs.getString("name"));

            return board;
        });
    }

    public Board findById(Long id) {

        String sql = """
                SELECT *
                FROM board
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {

                    Board board = new Board();

                    board.setId(rs.getLong("id"));
                    board.setBoardName(rs.getString("name"));

                    return board;

                }, id);
    }
}