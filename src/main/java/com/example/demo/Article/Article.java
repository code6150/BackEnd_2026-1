package com.example.demo.Article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class Article {
    private static Long followingId = 1L;

    private Long id;
    private String title;
    private String description;
    private LocalDateTime LDT;
    private Long memberId;
    private Long boardId;
    private LocalDateTime lastModifiedTime;

    public Article(String title, String description, Long memberId, Long boardId) {
        this.id = followingId++;
        this.title = title;
        this.description = description;
        this.memberId = memberId;
        this.boardId = boardId;
        this.LDT = LocalDateTime.now();
        lastModifiedTime = null;
    }

}
