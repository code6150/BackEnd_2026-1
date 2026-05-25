package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;


@Controller
public class ArticleController {

    private MembersRepository membersRepository;
    private ArticleRepository articleRepository;
    private BoardRepository boardRepository;

    @GetMapping("/posts")
    public String getArticlesView(Model model) {
        String boardTitle = boardRepository.findAll().get(0).getBoardName();
        model.addAttribute("boardTitle", boardTitle);
        model.addAttribute("articles", articleRepository.findAll());
        model.addAttribute("members", membersRepository.findAll());
        return "articles";
    }

    @ResponseBody
    @GetMapping("/articles")
    public HashMap<Long, Article> getArticles() {
        return articleRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!articleRepository.findAll().containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(articleRepository.findAll().get(id));
    }

    @ResponseBody
    @PostMapping("/article")
    public String createArticle(@RequestParam String title, @RequestParam String description) {

        return "생성 완료";
    }

    @ResponseBody
    @DeleteMapping("/article/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleRepository.findAll().remove(id);
        return "삭제 완료";
    }

    @ResponseBody
    @PutMapping("/article/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
        Article modifiedArticle = articleRepository.findAll().get(id);
        modifiedArticle.setTitle(updatedArticle.getTitle());
        modifiedArticle.setDescription(updatedArticle.getDescription());
        modifiedArticle.setLastModifiedTime(LocalDateTime.now());
        articleRepository.findAll().put(id, modifiedArticle);
        return "수정 완료";
    }
}
