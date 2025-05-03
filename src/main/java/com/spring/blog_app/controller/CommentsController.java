package com.spring.blog_app.controller;

import com.spring.blog_app.dto.CommentDto;
import com.spring.blog_app.entity.Post;
import com.spring.blog_app.service.CommentService;
import com.spring.blog_app.service.impl.CommentServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentsController {

    private CommentServiceImpl commentService;

    @Autowired
    public CommentsController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/post/{postId}/user/{userId}/comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto, @PathVariable Long postId, @PathVariable Long userId) {
        return new ResponseEntity<>(commentService.createComment(commentDto, postId, userId), HttpStatus.CREATED);
    }

    @GetMapping("post/{postId}/comment")
    public ResponseEntity<List<CommentDto>> getCommentsByPost(@PathVariable Long postId) {
        return new ResponseEntity<>(commentService.getCommentsByPost(postId), HttpStatus.OK);
    }

    @DeleteMapping("comment/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
