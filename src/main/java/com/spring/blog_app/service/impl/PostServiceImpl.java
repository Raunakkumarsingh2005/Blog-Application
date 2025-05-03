package com.spring.blog_app.service.impl;

import com.spring.blog_app.dto.PostDto;
import com.spring.blog_app.entity.Post;
import com.spring.blog_app.mapper.PostMapper;
import com.spring.blog_app.repository.PostRepository;
import com.spring.blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;
    private PostMapper postMapper;

    @Autowired
    public PostServiceImpl(PostMapper postMapper,PostRepository postRepo) {
        this.postMapper = postMapper;
        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(Post post) {
        if (post != null) {
            post.setCreatedAt(new Date());
            postRepo.save(post);
            return postMapper.toDto(post);
        }
        return null;
    }

    @Override
    public PostDto getPostById(Long id) {
        if (postRepo.existsById(id)) {
            Post post = postRepo.getReferenceById(id);
            return postMapper.toDto(post);
        }
        return null;
    }

    @Override
    public List<PostDto> getAllPost() {
        ArrayList<PostDto> list = new ArrayList<>();
        List<Post> posts = postRepo.findAll();
        if (!posts.isEmpty()) {
            for (Post p : posts) {
                list.add(postMapper.toDto(p));
            }
            return list;
        }
        return null;
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        Post existingPost = postRepo.findById(id).orElseThrow();
        Optional.ofNullable(postDto.getContent()).ifPresent(existingPost::setContent);
        Optional.ofNullable(postDto.getTitle()).ifPresent(existingPost::setTitle);

        return postMapper.toDto(postRepo.save(existingPost));
    }

    @Override
    public boolean deletePost(Long id) {
        if (postRepo.existsById(id)) {
            postRepo.delete(postRepo.getReferenceById(id));
            return true;
        }
        return false;
    }
}
