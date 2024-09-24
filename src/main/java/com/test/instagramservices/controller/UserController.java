package com.test.instagramservices.controller;

import com.test.instagramservices.dto.UserDTO;
import com.test.instagramservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/byId/{userId}")
    public UserDTO getTestData(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }
}
