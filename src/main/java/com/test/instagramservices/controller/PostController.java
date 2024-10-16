package com.test.instagramservices.controller;

import com.test.instagramservices.dto.PostDTO;
import com.test.instagramservices.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/post")
public class PostController {

    private final PostService postService;

    @GetMapping(value = "/byId/{id}")
    public PostDTO getPostById(@PathVariable Long id) {

        log.info("Retriving post with ID:[{}]", id);
        return postService.findPostById(id);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<PostDTO>> getAllPost() {

        HttpHeaders corsHeader = new HttpHeaders();
        corsHeader.set("Access-Control-Allow-Origin", "*");
        log.info("Retrieving all post");
        return ResponseEntity.ok().headers(corsHeader).body(postService.findAllPost());
    }
}