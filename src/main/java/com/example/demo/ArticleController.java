package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class ArticleController {

    HashMap<Integer, Article> article = new HashMap<Integer, Article>();

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable int id) {
        return article.get(id);
    }

    @PostMapping("/article")
    public String postArticle(@RequestBody String description) {
        return "게시 완료";
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
