package com.spring.blog_app.service;

import com.spring.blog_app.dto.PostDto;
import com.spring.blog_app.entity.Post;

import java.util.List;

public interface PostService {
    public PostDto createPost(Post post);
    public PostDto getPostById(Long id);
    public List<PostDto> getAllPost();
    public PostDto updatePost(Long id, PostDto postDto);
    public boolean deletePost(Long id);
}
