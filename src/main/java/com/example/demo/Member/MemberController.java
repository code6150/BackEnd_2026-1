package com.example.demo.Member;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
        this.memberRepository = memberRepository;
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
    @PostMapping("/members")
    public ResponseEntity<?> createArticle(
            @RequestParam String nickName,
            @RequestParam String email,
            @RequestParam String passWord
    ) {
        if (nickName == null || email == null || passWord == null) {
            return ResponseEntity.status(400).body("조건을 충족하지 못한 요청입니다.");
        }
        memberService.createMember(nickName, email, passWord);
        return ResponseEntity.ok("생성 완료");
    }

    @ResponseBody
    @DeleteMapping("/members/{id}")
    public String deleteArticle(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "삭제 완료";
    }

    @ResponseBody
    @PutMapping("/members/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody Member updatedMember) {

        if (memberRepository.existsByEmailAddress(updatedMember.getEmailAddress())) {
            return ResponseEntity.status(409).body("이미 존재하는 이메일 입니다.");
        }
        memberService.updateMember(id, updatedMember);
        return ResponseEntity.ok("수정 완료");
    }

}
