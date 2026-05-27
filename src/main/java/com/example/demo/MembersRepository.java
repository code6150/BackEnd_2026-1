package com.example.demo;

import org.springframework.stereotype.Repository;
import java.util.HashMap;

@Repository
public class MembersRepository {

    private final HashMap<Long, Member> members = new HashMap<>();

    public MembersRepository() {
        this.members.put(1L, new Member("회원1", "member1@gmail.com", "1111"));
        this.members.put(2L, new Member("회원2", "member2@gmail.com", "2222"));
        this.members.put(3L, new Member("회원3", "member3@gmail.com", "3333"));
    }

    public HashMap<Long, Member> findAll() {
        return members;
    }

    public Member findById(Long id) {
        return members.get(id);
    }

}
