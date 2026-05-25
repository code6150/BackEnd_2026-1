package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ArticleService {

    Random random = new Random();

    private ArticleRepository articles;
    private MembersRepository members;
    private BoardRepository articleBoards;

    public void creatArticle(String title, String description) {
        Long authorId = members.findById(random.nextLong(members.size())).getId();
        Long boardId = articleBoards.get(0).getId();
        Article newArticle = new Article(title, description, authorId, boardId);
        articles.put(newArticle.getId(), newArticle);

    }
}
