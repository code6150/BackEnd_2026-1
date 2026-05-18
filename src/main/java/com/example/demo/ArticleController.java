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

    @PutMapping("/article")
    public String putArticle(@RequestParam int id, @RequestParam String description) {
        article.put(id, new Article(id, description));
        return "생성완료";
    }


}
