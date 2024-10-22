package com.test.instagramservices;

import com.test.instagramservices.dto.UserDTO;
import com.test.instagramservices.entities.User;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public final class UserMapper {

    private UserMapper(){}

    public static UserDTO buildUserDTO(User user) {
        UserDTO dto = UserDTO.builder()
                .name(user.getName())
                .userName(user.getUsername())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .active(user.isActive())
                .build();
        log.info("UserService::buildUserDTO [{}]", dto);
        return dto;
    }

    public static User buildUser(UserDTO dto) {
        User user = User.builder()
                .name(dto.getName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .username(dto.getUserName())
                .active(true)
                .createdAt(LocalDateTime.now())
                .build();

        log.info("UserService::buildUser [{}]", user);
        return user;
    }
}
