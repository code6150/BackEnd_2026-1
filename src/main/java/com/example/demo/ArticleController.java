package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ArticleController {

    HashMap<Integer, Article> article = new HashMap<Integer, Article>();

    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable int id) {
        if (!article.containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(article.get(id));
    }

    @PostMapping("/article")
    public String createArticle(@RequestParam String description) {
        int newId = 0;
        while (article.containsKey(newId)) {
            newId++;
        }
        article.put(newId, new Article(newId, description));
        return "생성 완료";
    }

    @DeleteMapping("/article/{id}")
    public String deleteArticle(@PathVariable int id) {
        article.remove(id);
        return "삭제 완료";
    }

    @PutMapping("/article/{id}")
    public String updateArticle(@PathVariable int id, @RequestBody Article updatedArticle) {
        article.put(id, updatedArticle);
        return "수정 완료";
    }
}
