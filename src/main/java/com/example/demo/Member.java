package com.example.demo;

public class Member {
    public Member(String nickName, String email, String passWord) {
        id++;
        this.nickName = nickName;
        this.emailAddress = email;
        this.passWord = passWord;
    }

    private static Long id;
    private String nickName;
    private String emailAddress;
    private String passWord;

    public Long getId() {
        return id;
    }
}