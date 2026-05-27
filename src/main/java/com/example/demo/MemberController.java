package com.example.demo;

import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MembersRepository membersRepository;

    public MemberController(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }



}
