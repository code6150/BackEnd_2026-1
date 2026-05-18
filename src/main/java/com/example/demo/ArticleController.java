package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @GetMapping("/article/{id}")
    public String getArticle() {
        return "안뇽";
    }
}
