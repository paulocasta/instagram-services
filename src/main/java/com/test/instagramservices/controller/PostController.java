package com.test.instagramservices.controller;

import com.test.instagramservices.dto.PostDTO;
import com.test.instagramservices.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
