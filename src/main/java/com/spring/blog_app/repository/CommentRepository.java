package com.spring.blog_app.repository;

import com.spring.blog_app.entity.Comment;;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
