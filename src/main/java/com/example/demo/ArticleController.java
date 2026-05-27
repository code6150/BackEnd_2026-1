package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;

    public ArticleController(ArticleService articleService, MemberService memberService) {
        this.articleService = articleService;
        this.memberService = memberService;
    }

    @GetMapping("/posts")
    public String getArticlesView(Model model) {
        String boardTitle = articleService.getBoards().get(0).getBoardName();
        model.addAttribute("boardTitle", boardTitle);
        model.addAttribute("articles", articleService.getArticle());
        model.addAttribute("members", memberService.getMembers());
        return "articles";
    }

    @ResponseBody
    @GetMapping("/articles")
    public HashMap<Long, Article> getArticles() {
        return articleService.getArticle();
    }

    @ResponseBody
    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!articleService.getArticle().containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(articleService.getArticle().get(id));
    }

    @ResponseBody
    @PostMapping("/article")
    public String createArticle(@RequestParam String title, @RequestParam String description) {
        articleService.creatArticle(title, description);
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
