package com.example.demo.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Member {

    private Long id;
    private String nickName;
    private String emailAddress;
    private String passWord;

    public Member(String nickName, String email, String passWord) {
        this.nickName = nickName;
        this.emailAddress = email;
        this.passWord = passWord;
    }

    public void modifyMember(String modifiedNickName,
                             String modifiedEmail,
                             String modifiedPassWord) {

        this.nickName = modifiedNickName;
        this.emailAddress = modifiedEmail;
        this.passWord = modifiedPassWord;
    }
}