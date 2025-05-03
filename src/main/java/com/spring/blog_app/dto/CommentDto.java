package com.spring.blog_app.dto;


import com.spring.blog_app.entity.Users;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Date;

public class CommentDto {
    private Long id;
    private String description;
    private Long userId;
    private Long postId;
    private Date CreatedAt;

    public CommentDto(Long id, String description, Long userId, Long postId, Date createdAt) {
        this.id = id;
        this.description = description;
        this.userId = userId;
        this.postId = postId;
        CreatedAt = createdAt;
    }
//getters and setters

    public Long getUserId() {
        return userId;
    }

    public CommentDto setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getPostId() {
        return postId;
    }

    public CommentDto setPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public CommentDto setCreatedAt(Date createdAt) {
        CreatedAt = createdAt;
        return this;
    }


    public Long getId() {
        return id;
    }

    public CommentDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CommentDto setDescription(String description) {
        this.description = description;
        return this;
    }
}
