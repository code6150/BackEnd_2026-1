package com.example.demo;

public class Member {
    public Member(String nickName, String email, String passWord) {
        id++;
        this.nickName = nickName;
        this.emailAddress = email;
        this.passWord = passWord;
    }

    private static Long id;
    private final String nickName;
    private final String emailAddress;
    private final String passWord;

    public Long getId() {
        return id;
    }
}