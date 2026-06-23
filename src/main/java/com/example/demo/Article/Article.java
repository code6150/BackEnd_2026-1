package com.example.demo.Article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "article")
@Getter @Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    private Long memberId;
    private Long boardId;

    public Article(String title, String description, Long memberId, Long boardId) {
        this.title = title;
        this.description = description;
        this.memberId = memberId;
        this.boardId = boardId;
        this.createdDate = LocalDateTime.now();
    }
}