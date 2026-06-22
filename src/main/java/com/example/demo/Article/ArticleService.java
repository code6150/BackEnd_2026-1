package com.example.demo.Article;

import com.example.demo.Board.Board;
import com.example.demo.Board.BoardRepository;
import com.example.demo.Member.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ArticleService {

    Random random = new Random();

    private final ArticleRepository articles;
    private final MemberRepository members;
    private final BoardRepository boardRepository;

    public ArticleService(
            ArticleRepository articleRepository,
            MemberRepository membersRepository,
            BoardRepository boardRepository
            ) {
        this.articles = articleRepository;
        this.members = membersRepository;
        this.boardRepository = boardRepository;

    }


    public HashMap<Long, Article> getArticles() {
        return articles.findAll();
    }

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public void updateArticle(Long id, Article updatedArticle) {
        Article modifiedArticle = articles.findAll().get(id);
        modifiedArticle.setTitle(updatedArticle.getTitle());
        modifiedArticle.setDescription(updatedArticle.getDescription());
        modifiedArticle.setLastModifiedTime(LocalDateTime.now());
        articles.findAll().put(id, modifiedArticle);
    }

    public void creatArticle(Long boardId, Long memberId, String title, String description) {
        Article newArticle = new Article(title, description, memberId, boardId);
        articles.findAll().put(newArticle.getId(), newArticle);
    }

    public void deleteArticle(Long id) {
        articles.findAll().remove(id);
    }

    public HashMap<Long, Article> getArticlesByBoardId(Long boardId) {
        return articles.findByBoardID(boardId);
    }
}
