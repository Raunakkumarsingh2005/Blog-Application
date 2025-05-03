package com.spring.blog_app.dto;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;

    public Long getId() {
        return id;
    }

    public PostDto setId(Long id) {
        this.id = id;
        return this;
    }

    public PostDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public PostDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostDto setContent(String content) {
        this.content = content;
        return this;
    }
}
