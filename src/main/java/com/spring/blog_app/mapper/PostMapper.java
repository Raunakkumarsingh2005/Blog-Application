package com.spring.blog_app.mapper;

import com.spring.blog_app.dto.PostDto;
import com.spring.blog_app.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    // Convert Post entity to PostDto
    public PostDto toDto(Post post) {
        return new PostDto(post.getId(), post.getTitle(), post.getContent());
    }

    // Convert PostDto to Post entity (if you need it for update operations)
    public Post toEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        return post;
    }
}
