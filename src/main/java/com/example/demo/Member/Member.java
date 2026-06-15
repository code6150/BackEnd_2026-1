package com.example.demo.Member;

public class Member {
    public Member(String nickName, String email, String passWord) {
        this.id = followingId++;
        this.nickName = nickName;
        this.emailAddress = email;
        this.passWord = passWord;
    }

    private static Long followingId= 1L;

    private final Long id;
    private String nickName;
    private String emailAddress;
    private String passWord;

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

    public void modifyMember(String modifiedNickName, String modifiedEmail, String modifiedPassWord) {
        nickName = modifiedNickName;
        emailAddress = modifiedEmail;
        passWord = modifiedPassWord;
    }

}