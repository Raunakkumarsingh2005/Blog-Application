package com.spring.blog_app.mapper;

import com.spring.blog_app.dto.CategoryDto;
import com.spring.blog_app.dto.CommentDto;
import com.spring.blog_app.entity.Category;
import com.spring.blog_app.entity.Comment;
import com.spring.blog_app.repository.CommentRepository;
import com.spring.blog_app.repository.PostRepository;
import com.spring.blog_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    private UserRepository userRepository;
    private PostRepository postRepository;

    @Autowired
    public CommentMapper(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public CommentDto toDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getDescription(), comment.getUser().getId(), comment.getPost().getId(), comment.getCreatedAt());
    }

    public Comment toEntity(CommentDto commentDto, Long userId, Long postId) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setDescription(commentDto.getDescription());
        comment.setUser(userRepository.findById(userId).orElseThrow());
        comment.setPost(postRepository.findById(postId).orElseThrow());
        comment.setCreatedAt(commentDto.getCreatedAt());
        return comment;
    }
}
