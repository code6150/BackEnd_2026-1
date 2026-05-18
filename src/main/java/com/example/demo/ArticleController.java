package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ArticleController {

    HashMap<Integer, Article> article = new HashMap<Integer, Article>();

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable int id) {
        return article.get(id);
    }

    @PutMapping("/article/{id}")
    public String putArticle() {return "a";}


}
