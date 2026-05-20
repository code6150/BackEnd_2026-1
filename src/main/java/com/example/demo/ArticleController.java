package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@RestController
public class ArticleController {

    HashMap<Long, Article> article = new HashMap<>();
    ArrayList<Member> member = new ArrayList<>();
    Random random = new Random();

    @PostConstruct
    public void setDefault() {
        ArticleBoard articleBoard = new ArticleBoard("자유게시판");

        member.add(new Member("회원1", "member1@gmail.com", "1111"));
        member.add(new Member("회원2", "member2@gmail.com", "2222"));
        member.add(new Member("회원3", "member3@gmail.com", "3333"));
    }

    @GetMapping("/articles")
    public HashMap<Long, Article> getArticles() {
        return article;
    }

    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!article.containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(article.get(id));
    }

    @PostMapping("/article")
    public String createArticle(@RequestParam String title, @RequestParam String description) {
        String author = member.get(random.nextInt(member.size())).getNickName();
        Article newArticle = new Article(title, description, author);
        article.put(newArticle.getId(), newArticle);
        return "생성 완료";
    }

    @DeleteMapping("/article/{id}")
    public String deleteArticle(@PathVariable Long id) {
        article.remove(id);
        return "삭제 완료";
    }

    @PutMapping("/article/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Article modifiedArticle = article.get(id);
        modifiedArticle.setTitle(updatedArticle.getTitle());
        modifiedArticle.setDescription(updatedArticle.getDescription());
        modifiedArticle.setLastModifiedTime(LocalDateTime.now());
        article.put(id, modifiedArticle);
        return "수정 완료";
    }
}
