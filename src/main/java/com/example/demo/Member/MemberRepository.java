package com.example.demo.Member;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.HashMap;

@Repository
public class MemberRepository {

    private final HashMap<Long, Member> members = new HashMap<>();

    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.members.put(1L, new Member("회원1", "member1@gmail.com", "1111"));
        this.members.put(2L, new Member("회원2", "member2@gmail.com", "2222"));
        this.members.put(3L, new Member("회원3", "member3@gmail.com", "3333"));
    }

    private final JdbcTemplate jdbcTemplate;

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

    public HashMap<Long, Member> findAll() {
        return members;
    }

    public Member findById(Long id) {
        return members.get(id);
    }

    public boolean existsByEmailAddress(String emailAddress) {
        for (Member member : members.values()) {
            if (member.getEmailAddress().equals(emailAddress)) {
                return true;
            }
        }
        return false;
    }

}
