package com.test.instagramservices.service;

import com.test.instagramservices.UserMapper;
import com.test.instagramservices.dto.UserDTO;
import com.test.instagramservices.entities.User;
import com.test.instagramservices.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserDTO findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(UserMapper::buildUserDTO).orElse(null);
    }

    public void createUser(UserDTO dto) {
        userRepository.save(UserMapper.buildUser(dto));
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<String> updateUser(UserDTO dto) {

        User user = userRepository.findByUsername(dto.getUserName());
        if (user == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        if (dto.getName() != null && !dto.getName().isEmpty()) {
            user.setName(dto.getName());
        }

        if (dto.getLastName() != null && !dto.getLastName().isEmpty()) {
            user.setLastName(dto.getLastName());
        }

        if (dto.getEmail() != null && !dto.getEmail().isEmpty()) {
            user.setEmail(dto.getEmail());
        }
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return  ResponseEntity.ok("User updated");
    }
}
