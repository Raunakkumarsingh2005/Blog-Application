package com.spring.blog_app.controller;

import com.spring.blog_app.dto.PostDto;
import com.spring.blog_app.entity.Post;
import com.spring.blog_app.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class PostController {
    PostServiceImpl postService;

    @Autowired
    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping("/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody Post post) {
        PostDto savedPost = postService.createPost(post);
        if (savedPost != null) {
            return new ResponseEntity(savedPost, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/posts/{id}") // error in this api
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) {
        if (id != null && postService.getPostById(id) != null) {
            return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
        } else if (postService.getPostById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        try {
            if (id != null) {
                return new ResponseEntity<>(postService.updatePost(id, postDto), HttpStatus.OK);
            }
        }catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity deletePost(@PathVariable Long id) {
        if (postService.deletePost(id)) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

//    @DeleteMapping("/test")
//    public String test() {
//        return "It is working";
//    }
}
