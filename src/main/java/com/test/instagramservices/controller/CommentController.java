package com.test.instagramservices.controller;

import com.test.instagramservices.dto.CommentDTO;
import com.test.instagramservices.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/byId/{id}")
    public CommentDTO findCommentById(@PathVariable Long id) {
        return commentService.findByCommentId(id);
    }
}
