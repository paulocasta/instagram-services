package com.test.instagramservices.repository;

import com.test.instagramservices.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostIdAndActiveIsTrue(Long postId);
}
