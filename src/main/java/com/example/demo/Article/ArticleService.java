package com.example.demo.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articles;

    public ArticleService(
            ArticleRepository articleRepository
    ) {
        this.articles = articleRepository;
    }

    @Transactional(readOnly = true)
    public List<Article> getArticles() {
        return articles.findAll();
    }

    @Transactional(readOnly = true)
    public List<Article> getArticlesByBoardId(Long boardId) {
        return articles.findByBoardId(boardId);
    }

    @Transactional
    public void createArticle(Long boardId,
                              Long memberId,
                              String title,
                              String description) {

        Article article = new Article(
                title,
                description,
                memberId,
                boardId
        );

        articles.save(article);
    }

    @Transactional
    public void updateArticle(Long id, Article updatedArticle) {

        Article article = articles.findById(id);

        article.setTitle(updatedArticle.getTitle());
        article.setDescription(updatedArticle.getDescription());
        article.setLastModifiedTime(LocalDateTime.now());

        articles.update(article);
    }

    @Transactional
    public void deleteArticle(Long id) {
        articles.delete(id);
    }
}