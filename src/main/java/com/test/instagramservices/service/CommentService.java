package com.test.instagramservices.service;

import com.test.instagramservices.dto.CommentDTO;
import com.test.instagramservices.entities.Comment;
import com.test.instagramservices.mapper.CommentMapper;
import com.test.instagramservices.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {

    private static final ResponseEntity<String> COMMENT_NOT_FOUND = ResponseEntity.status(404).body("Comment not found");

    private final CommentRepository commentRepository;

    public CommentDTO findByCommentId(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(CommentMapper::buildCommentDTO).orElse(null);
    }

    public ResponseEntity<List<CommentDTO>> findAllCommentsByPostId(Long id) {
        List<Comment> comments = commentRepository.findAllByPostIdAndActiveIsTrue(id);
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
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            log.info("Deleting comment");
            commentRepository.delete(comment.get());
            return ResponseEntity.ok("Comment deleted");
        }
        return COMMENT_NOT_FOUND;
    }

    public ResponseEntity<String> disableComment(Long id) {
        return updateActiveComment(id, false);
    }

    public ResponseEntity<String> enableComment(Long id) {
        return updateActiveComment(id, true);
    }

    private ResponseEntity<String> updateActiveComment(Long id, boolean active) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent()) {
            Comment cmt = comment.get();
            cmt.setActive(active);
            cmt.setUpdatedAt(LocalDateTime.now());
            commentRepository.save(cmt);
            return active ? ResponseEntity.ok("Comment enable") : ResponseEntity.ok("Comment disabled");
        }
        return COMMENT_NOT_FOUND;
    }
}

