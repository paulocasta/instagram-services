package com.test.instagramservices.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Data
@ToString
public class CommentDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private Long postId;
    private Long fromUserId;
    private String comment;
    private LocalDateTime createdAt;
}
