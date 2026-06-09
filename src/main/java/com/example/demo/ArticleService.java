package com.example.demo;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ArticleService {

    Random random = new Random();

    private final ArticleRepository articles;
    private final MembersRepository members;
    private final BoardRepository boardRepository;

    public ArticleService(
            ArticleRepository articleRepository,
            MembersRepository membersRepository,
            BoardRepository boardRepository
            ) {
        this.articles = articleRepository;
        this.members = membersRepository;
        this.boardRepository = boardRepository;

    }


    public HashMap<Long,Article> getArticles() {
        return articles.findAll();
    }

    public HashMap<Long,ArticleBoard> getBoards() {
        return boardRepository.findAll();
    }

    public void updateArticle(Long id, Article updatedArticle) {
        Article modifiedArticle = articles.findAll().get(id);
        modifiedArticle.setTitle(updatedArticle.getTitle());
        modifiedArticle.setDescription(updatedArticle.getDescription());
        modifiedArticle.setLastModifiedTime(LocalDateTime.now());
        articles.findAll().put(id, modifiedArticle);
    }

    public void creatArticle(String title, String description) {
        Long authorId = members.findById(random.nextLong(members.findAll().size())).getId();
        Long boardId = boardRepository.findAll().get(0).getId();
        Article newArticle = new Article(title, description, authorId, boardId);
        articles.findAll().put(newArticle.getId(), newArticle);
    }

    public void deleteArticle(Long id) {
        articles.findAll().remove(id);
    }
}
