package com.example.demo.Board;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class BoardRepository {

    private final HashMap<Long, Board> articleBoards = new HashMap<>();
    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.articleBoards.put(1L, new Board("자유게시판"));
    }

    private final JdbcTemplate jdbcTemplate;


    public void save(Board board) {

        String sql = """
                INSERT INTO board(name)
                VALUES (?)
                """;

        jdbcTemplate.update(sql, board.getBoardName());
    }

    public HashMap<Long, Board> findAll() {
        return articleBoards;
    }

}
