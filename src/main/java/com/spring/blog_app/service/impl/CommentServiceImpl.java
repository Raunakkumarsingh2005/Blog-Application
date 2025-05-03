package com.spring.blog_app.service.impl;

import com.spring.blog_app.dto.CommentDto;
import com.spring.blog_app.entity.Comment;
import com.spring.blog_app.entity.Post;
import com.spring.blog_app.mapper.CommentMapper;
import com.spring.blog_app.repository.CommentRepository;
import com.spring.blog_app.repository.PostRepository;
import com.spring.blog_app.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Long userId, Long postId) {
        Comment comment = commentMapper.toEntity(commentDto, userId, postId);
        commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.findById(id).orElseThrow();
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentDto> getCommentsByPost(Long postId) {
        List<Comment> comments = commentRepository.findAll();
        List<CommentDto> commentList = new ArrayList<>();
        for (Comment c : comments) {
            if (Objects.equals(c.getPost().getId(), postId)) {
                commentList.add(commentMapper.toDto(c));
            }
        }
        return commentList;
    }
}
