package com.test.instagramservices.service;

import com.test.instagramservices.dto.PostDTO;
import com.test.instagramservices.entities.Post;
import com.test.instagramservices.entities.User;
import com.test.instagramservices.mapper.PostMapper;
import com.test.instagramservices.repository.PostRepository;
import com.test.instagramservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostDTO findPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.map(PostMapper::buildPostDTO).orElse(null);
    }

    public List<PostDTO> findAllPost() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::buildPostDTO).toList();
    }

    public List<PostDTO> findAllFollowPost(Long id) {
        List<Post> posts = postRepository.findAllFollowPost(id);
        return posts.stream().map(PostMapper::buildPostDTO).toList();
    }

    public ResponseEntity<String> createPost(PostDTO dto) {
        Post post = PostMapper.buildPost(dto);
        Optional<User> user = userRepository.findById(dto.getUserId());
        if (user.isPresent()) {
            log.info("Saving post");
            post.setUser(user.get());
            postRepository.save(post);
            return ResponseEntity.ok("Post created");
        }
        return ResponseEntity.status(404).body("Post not created, user not found");
    }

    public ResponseEntity<String> deletePostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            log.info("Deleting post");
            postRepository.delete(post.get());
            return ResponseEntity.ok("Post deleted");
        }
        return ResponseEntity.status(404).body("Post not found");
    }
}
