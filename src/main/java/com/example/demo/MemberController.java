package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseBody
    @GetMapping("/members")
    public HashMap<Long, Member> getArticles() {
        return memberService.getMembers();
    }

    @ResponseBody
    @GetMapping("/members/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!memberService.getMembers().containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 회원입니다.");
        }
        return ResponseEntity.ok(memberService.getMembers().get(id));
    }

    @ResponseBody
    @PostMapping("/article")
    public String createArticle(
            @RequestParam String nickName,
            @RequestParam String email,
            @RequestParam String passWord
    ) {
        memberService.creatMember(nickName, email, passWord);
        return "생성 완료";
    }

    @ResponseBody
    @DeleteMapping("/article/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "삭제 완료";
    }

    @ResponseBody
    @PutMapping("/article/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        articleService.updateArticle(id, updatedArticle);
        return "수정 완료";
    }

}
