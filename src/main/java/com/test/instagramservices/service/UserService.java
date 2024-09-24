package com.test.instagramservices.service;

import com.test.instagramservices.domain.User;
import com.test.instagramservices.dto.UserDTO;
import com.test.instagramservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDTO findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserService::buildUser).orElse(null);
    }

    private static UserDTO buildUser(User user) {
        UserDTO dto = UserDTO.builder()
                .name(user.getName())
                .userName(user.getUsername())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .active(user.isActive())
            .build();
        log.info("UserService::buildUser [{}]", dto);
        return dto;
    }
}
