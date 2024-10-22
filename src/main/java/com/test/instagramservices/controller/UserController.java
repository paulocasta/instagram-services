package com.test.instagramservices.controller;

import com.test.instagramservices.dto.UserDTO;
import com.test.instagramservices.service.UserService;
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

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/{userId}")
    public UserDTO getUserById(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto) {
        log.info("UserController::saveUser dto={}", dto);
        userService.createUser(dto);
        return ResponseEntity.ok("User Saved");
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        log.info("UserController::deleteId id={}", id);
        userService.deleteUserById(id);
        return ResponseEntity.ok("User deleted");
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserDTO dto) {
        log.info("UserController::updateUser dto={}", dto);
        return userService.updateUser(dto);
    }
}
