package com.test.instagramservices.controller;

import com.test.instagramservices.dto.PostDTO;
import com.test.instagramservices.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/post")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/{id}")
    public PostDTO getPostById(@PathVariable Long id) {
        log.info("Retrieving post with ID:[{}]", id);
        return postService.findPostById(id);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PostDTO>> getAllPost() {
        HttpHeaders corsHeader = new HttpHeaders();
        corsHeader.set("Access-Control-Allow-Origin", "*");
        log.info("Retrieving all post");
        return ResponseEntity.ok().headers(corsHeader).body(postService.findAllPost());
    }

    @GetMapping(value = "/allFollow/{id}")
    public ResponseEntity<List<PostDTO>> getAllFollowPost(@PathVariable Long id) {
        HttpHeaders corsHeader = new HttpHeaders();
        corsHeader.set("Access-Control-Allow-Origin", "*");
        log.info("Retrieving all post");
        return ResponseEntity.ok().headers(corsHeader).body(postService.findAllFollowPost(id));
    }

    @PostMapping
    public ResponseEntity<String> createPost(@RequestBody PostDTO dto) {
        log.info("PostController::createPost dto={}", dto);
        return postService.createPost(dto);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        log.info("PostController::deletePost id={}", id);
        return postService.deletePostById(id);
    }

    @PutMapping(value = "/disable/{id}")
    public ResponseEntity<String> disablePost(@PathVariable Long id) {
        log.info("PostController::disableComment id={}", id);
        return postService.disablePost(id);
    }

    @PutMapping(value = "/enable/{id}")
    public ResponseEntity<String> enablePost(@PathVariable Long id) {
        log.info("PostController::enableComment id={}", id);
        return postService.enablePost(id);
    }
}
