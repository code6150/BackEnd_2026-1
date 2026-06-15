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
    @GetMapping("/article/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!articleService.getArticles().containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(articleService.getArticles().get(id));
    }

    @ResponseBody
    @GetMapping("articles")
    public ResponseEntity<?> getArticleInBoard(@RequestParam(required = false) Long boardId) {
        if (boardId == null) {
            return ResponseEntity.ok(articleService.getArticles());
        }
        if (!boardService.getBoards().containsKey(boardId)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시판입니다.");
        }
        return ResponseEntity.ok(articleService.getArticlesByBoardId(boardId));
    }

    @ResponseBody
    @PostMapping("/article")
    public ResponseEntity<?> createArticle(@RequestParam String title, @RequestParam String description) {
        articleService.creatArticle(title, description);
        //현재 게시글 생성할때 랜덤한 회원과 게시판을 불러오는 관계로 주석으로만 구현해놓겠습니다..
//        if (!memberService.getMembers().containsKey(memberId)) {
//            return ResponseEntity.status(400).body("게시글을 작성한 회원이 없습니다;;");
//        }
//        if (!boardService.getBoards().containsKey(boardId)) {
//            return ResponseEntity.status(400).body("현재 존재하지 않는 게시판입니다.");
//        }
        return ResponseEntity.ok("생성 완료");
    }

    @ResponseBody
    @DeleteMapping("/article/{id}")
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "삭제 완료";
    }

    @ResponseBody
    @PutMapping("/article/{id}")
    public ResponseEntity<?> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {

        if (!memberService.getMembers().containsKey(updatedArticle.getMemberId())) {
            return ResponseEntity.status(400).body("게시글을 작성한 회원이 없습니다;;");
        }
        if (!boardService.getBoards().containsKey(updatedArticle.getBoardId())) {
            return ResponseEntity.status(400).body("현재 존재하지 않는 게시판입니다.");
        }
        articleService.updateArticle(id, updatedArticle);
        return ResponseEntity.ok("수정 완료");
    }
}
