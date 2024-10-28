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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {

    private static final ResponseEntity<String> POST_NOT_FOUND = ResponseEntity.status(404).body("Post not found");

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
        return ResponseEntity.status(404).body("User not found");
    }

    public ResponseEntity<String> deletePostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            log.info("Deleting post");
            postRepository.delete(post.get());
            return ResponseEntity.ok("Post deleted");
        }
        return POST_NOT_FOUND;
    }

    public ResponseEntity<String> disablePost(Long id) {
        return updateActivePost(id, false);
    }

    public ResponseEntity<String> enablePost(Long id) {
        return updateActivePost(id, true);
    }

    private ResponseEntity<String> updateActivePost(Long id, boolean active) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post ps = post.get();
            ps.setActive(active);
            ps.setUpdatedAt(LocalDateTime.now());
            postRepository.save(ps);
            return active ? ResponseEntity.ok("Post enable") : ResponseEntity.ok("Post disabled");
        }
        return POST_NOT_FOUND;
    }
}
