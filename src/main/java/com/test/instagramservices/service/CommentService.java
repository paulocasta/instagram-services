package com.test.instagramservices.service;

import com.test.instagramservices.domain.Comment;
import com.test.instagramservices.dto.CommentDTO;
import com.test.instagramservices.repository.CommentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentDTO findByCommentId(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(CommentService::buildComment).orElse(null);
    }

    private static CommentDTO buildComment(Comment comment) {
        CommentDTO dto = CommentDTO.builder()
                .postId(comment.getPostId())
                .createdAt(comment.getCreatedAt())
                .active(comment.isActive())
                .fromUserId(comment.getFromUserId())
                .comment(comment.getComment())
                .build();
        log.info("CommentController::buildComment [{}]", dto);
        return dto;
    }
}

