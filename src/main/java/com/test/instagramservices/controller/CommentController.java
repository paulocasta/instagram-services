package com.test.instagramservices.controller;

import com.test.instagramservices.dto.CommentDTO;
import com.test.instagramservices.service.CommentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping(value = "/comment")
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "{id}")
    public CommentDTO findCommentById(@PathVariable Long id) {
        return commentService.findByCommentId(id);
    }

    @GetMapping(value = "/postId/{id}")
    public ResponseEntity<List<CommentDTO>> findAllCommentsByPostId(@PathVariable Long id) {
        return commentService.findAllCommentsByPostId(id);
    }

    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentDTO dto) {
        log.info("CommentController::createComment dto={}", dto);
        return commentService.createComment(dto);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        log.info("CommentController::deleteId id={}", id);
        return commentService.deleteCommentById(id);
    }

    @PutMapping(value = "/disable/{id}")
    public ResponseEntity<String> disableComment(@PathVariable Long id) {
        log.info("CommentController::disableComment id={}", id);
        return commentService.disableComment(id);
    }

    @PutMapping(value = "/enable/{id}")
    public ResponseEntity<String> enableComment(@PathVariable Long id) {
        log.info("CommentController::enableComment id={}", id);
        return commentService.enableComment(id);
    }

}
