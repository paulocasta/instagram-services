package com.test.instagramservices.mapper;

import com.test.instagramservices.dto.PostDTO;
import com.test.instagramservices.entities.Post;

import java.time.LocalDateTime;

public final class PostMapper {

    private PostMapper(){}

    public static PostDTO buildPostDTO(Post post) {
        return PostDTO.builder()
                .postId(post.getId())
                .userId(post.getUser().getId())
                .userName(post.getUser().getName())
                .createdAt(DateMapper.getPublishedTime(post.getCreatedAt()))
                .imageUrl(post.getImageUrl())
                .build();
    }

    public static Post buildPost(PostDTO dto) {
        return Post.builder()
                .imageUrl(dto.getImageUrl())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
