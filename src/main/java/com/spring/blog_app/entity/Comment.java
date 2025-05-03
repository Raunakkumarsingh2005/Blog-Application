package com.spring.blog_app.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @CreationTimestamp
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "users")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "Post")
    private Post post;

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }

    public Users getUser() {
        return user;
    }

    public Comment setUser(Users user) {
        this.user = user;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Comment setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Comment setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Comment setId(Long id) {
        this.id = id;
        return this;
    }
}
