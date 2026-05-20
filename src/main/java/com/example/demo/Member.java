package com.example.demo;

public class Member {
    public Member(String nickName, String email, String passWord) {
        this.id = followingId++;
        this.nickName = nickName;
        this.emailAddress = email;
        this.passWord = passWord;
    }

    private static Long followingId= 1L;

    private final Long id;
    private final String nickName;
    private final String emailAddress;
    private final String passWord;

    public Long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassWord() {
        return passWord;
    }
}