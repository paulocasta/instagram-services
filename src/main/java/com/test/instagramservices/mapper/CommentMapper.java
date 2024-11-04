package com.test.instagramservices.mapper;

import com.test.instagramservices.dto.CommentDTO;
import com.test.instagramservices.entities.Comment;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public final class CommentMapper {

    private CommentMapper(){}

    public static CommentDTO buildCommentDTO(Comment comment) {
        return CommentDTO.builder()
                .postId(comment.getPostId())
                .createdAt(comment.getCreatedAt())
                .fromUserId(comment.getFromUserId())
                .comment(comment.getComment())
                .build();
    }

    public static Comment buildComment(CommentDTO dto) {
        return Comment.builder()
                .active(true)
                .postId(dto.getPostId())
                .comment(dto.getComment())
                .fromUserId(dto.getFromUserId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
