package com.example.demo.Article;

import com.example.demo.Board.BoardService;
import com.example.demo.Member.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Controller
public class ArticleController {

    private final ArticleService articleService;
    private final MemberService memberService;
    private final BoardService boardService;

    public ArticleController(ArticleService articleService, MemberService memberService, BoardService boardService) {
        this.articleService = articleService;
        this.memberService = memberService;
        this.boardService = boardService;
    }

    @GetMapping("/posts")
    public String getArticlesView(Model model) {
        String boardTitle = articleService.getBoards().get(1L).getBoardName();
        model.addAttribute("boardTitle", boardTitle);
        model.addAttribute("articles", articleService.getArticles());
        model.addAttribute("members", memberService.getMembers());
        return "articles";
    }

    @ResponseBody
    @GetMapping("/articles")
    public HashMap<Long, Article> getArticles() {
        return articleService.getArticles();
    }

    @ResponseBody
    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!articleService.getArticles().containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(articleService.getArticles().get(id));
    }

    @ResponseBody
    @GetMapping("articles")
    public ResponseEntity<?> getArticleInBoard(@RequestParam Long boardId) {
        if (!boardService.getBoards().containsKey(boardId)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시판입니다.");
        }
        return ResponseEntity.ok(articleService.getArticles());
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
