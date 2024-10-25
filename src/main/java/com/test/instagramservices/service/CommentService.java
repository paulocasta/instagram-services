package com.test.instagramservices.service;

import com.test.instagramservices.entities.Comment;
import com.test.instagramservices.dto.CommentDTO;
import com.test.instagramservices.entities.Post;
import com.test.instagramservices.mapper.CommentMapper;
import com.test.instagramservices.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentDTO findByCommentId(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(CommentMapper::buildCommentDTO).orElse(null);
    }

    public ResponseEntity<List<CommentDTO>> findAllCommentsByPostId(Long id) {
        List<Comment> comments = commentRepository.findAllByPostId(id);
        return ResponseEntity.ok(comments.stream().map(CommentMapper::buildCommentDTO).toList());
    }

    public ResponseEntity<String> createComment(CommentDTO dto) {
        try {
            commentRepository.save(CommentMapper.buildComment(dto));
        } catch (Exception e) {
            log.error("Something went wrong while creating the comment", e);
            return ResponseEntity.status(400).body("Cannot create the comment");
        }
        return ResponseEntity.ok("Comment created");
    }

    public ResponseEntity<String> deleteCommentById(Long id) {
        Optional<Comment> post = commentRepository.findById(id);
        if (post.isPresent()) {
            log.info("Deleting comment");
            commentRepository.delete(post.get());
            return ResponseEntity.ok("Comment deleted");
        }
        return ResponseEntity.status(404).body("Post not found");
    }
}

