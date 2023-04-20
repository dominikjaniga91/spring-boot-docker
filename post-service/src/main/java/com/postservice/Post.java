package com.postservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @author Dominik_Janiga
 */
@Entity
@Table(name = "posts")
@ToString
class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(name = "author_id")
    private Long authorId;

    private String text;

    @Column(name = "posted_at")
    private LocalDateTime postedAt;


    public Post() {

    }

    public Post(long authorId, String text) {
        this.authorId = authorId;
        this.text = text;
        this.postedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public PostResponseDto toResponseDto() {
        return new PostResponseDto(id, authorId, text, postedAt);
    }
}
