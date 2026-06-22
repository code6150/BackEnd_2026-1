package com.example.demo.Member;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Member member) {

        String sql = """
                INSERT INTO member(name, email, password)
                VALUES (?, ?, ?)
                """;

        jdbcTemplate.update(
                sql,
                member.getNickName(),
                member.getEmailAddress(),
                member.getPassWord()
        );
    }

    public List<Member> findAll() {

        String sql = "SELECT * FROM member";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Member member = new Member();

            member.setId(rs.getLong("id"));
            member.setNickName(rs.getString("name"));
            member.setEmailAddress(rs.getString("email"));
            member.setPassWord(rs.getString("password"));

            return member;
        });
    }

    public Member findById(Long id) {

        String sql = """
                SELECT *
                FROM member
                WHERE id = ?
                """;

        return jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> {

                    Member member = new Member();

                    member.setId(rs.getLong("id"));
                    member.setNickName(rs.getString("name"));
                    member.setEmailAddress(rs.getString("email"));
                    member.setPassWord(rs.getString("password"));

                    return member;
                },
                id
        );
    }

    public boolean existsByEmailAddress(String emailAddress) {

        String sql = """
                SELECT COUNT(*)
                FROM member
                WHERE email = ?
                """;

        Integer count = jdbcTemplate.queryForObject(
                sql,
                Integer.class,
                emailAddress
        );

        return count != null && count > 0;
    }
}