package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class BoardController {


    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //모든게시판 조회
    @ResponseBody
    @GetMapping("/boards")
    public HashMap<Long, ArticleBoard> getBoards() {
        return boardService.getBoards();
    }

    //특정게시판 조회
    @ResponseBody
    @GetMapping("/boards/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        if (!boardService.getBoards().containsKey(id)) {
            return ResponseEntity.status(404).body("존재하지 않는 게시물입니다.");
        }
        return ResponseEntity.ok(boardService.getBoards().get(id));
    }

    //게시판 추가
    @ResponseBody
    @PostMapping("/boards")
    public String createArticle(@RequestParam String boardName) {
        boardService.creatBoard(boardName);
        return "생성 완료";
    }

    //게시판 삭제
    @ResponseBody
    @DeleteMapping("/boards/{id}")
    public String deleteBoard(@PathVariable Long id) {
        boardService.deleteBoard(id);
        return "삭제 완료";
    }

    //게시판 수정
    @ResponseBody
    @PutMapping("/boards/{id}")
    public String updateBoard(@PathVariable Long id, @RequestBody ArticleBoard updatedBoard) {
        boardService.updateBoard(id, updatedBoard);
        return "수정 완료";
    }

}
