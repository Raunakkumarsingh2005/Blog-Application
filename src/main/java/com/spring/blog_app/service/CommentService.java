package com.spring.blog_app.service;

import com.spring.blog_app.dto.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto createComment(CommentDto commentDto, Long userId, Long postId);
    public void deleteComment(Long id);
    public List<CommentDto> getCommentsByPost(Long id);
}
