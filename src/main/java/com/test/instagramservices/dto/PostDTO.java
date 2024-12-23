package com.test.instagramservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
@JsonIgnoreProperties
public class PostDTO {

    private Long postId;
    private Long userId;
    private String userName;
    private String imageUrl;
    private Long likes;
    private String createdAt;
}
