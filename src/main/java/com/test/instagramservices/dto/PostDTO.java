package com.test.instagramservices.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Data
@ToString
@JsonIgnoreProperties
public class PostDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private Long userId;
    private String imageUrl;
    private Long likes;
    private boolean active;
    private LocalDateTime createdAt;
}
