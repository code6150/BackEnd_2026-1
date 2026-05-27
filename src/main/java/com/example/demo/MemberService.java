package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {

    private final MembersRepository members;

    public MemberService(MembersRepository membersRepository) {
        this.members = membersRepository;
    }

    public HashMap<Long, Member> getMembers() {
        return members.findAll();
    }

    public void creatMember(String nickName, String email, String passWord) {
        Member newMember = new Member(nickName, email, passWord);
        members.findAll().put(newMember.getId(), newMember);
    }

}
