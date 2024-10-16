package com.test.instagramservices.service;

import com.test.instagramservices.domain.Post;
import com.test.instagramservices.dto.PostDTO;
import com.test.instagramservices.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository userRepository;

    public PostDTO findPostById(Long postId) {
        Optional<Post> user = userRepository.findById(postId);
        return user.map(PostService::buildPost).orElse(null);
    }

    private static PostDTO buildPost(Post post) {
        PostDTO dto = PostDTO.builder()
                .userId(post.getUser().getId())
                .userName(post.getUser().getName())
                .active(post.isActive())
                .createdAt(post.getCreatedAt())
                .likes(post.getLikes())
                .imageUrl(post.getImageUrl())
                .build();
        log.info("PostService::buildPost [{}]", dto);
        return dto;
    }

    public List<PostDTO> findAllPost() {
        List<Post> posts = userRepository.findAll();
        return posts.stream().map(PostService::buildPost).toList();
    }
}
