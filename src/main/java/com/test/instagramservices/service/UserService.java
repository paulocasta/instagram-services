package com.test.instagramservices.service;

import com.test.instagramservices.dto.UserDTO;
import com.test.instagramservices.entities.User;
import com.test.instagramservices.mapper.UserMapper;
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

    private static final ResponseEntity<String> USER_NOT_FOUND = ResponseEntity.status(404).body("User not found");

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
            return USER_NOT_FOUND;
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
        return ResponseEntity.ok("User updated");
    }

    public ResponseEntity<String> disableUser(Long id) {
        return updateActiveUser(id, false);
    }

    public ResponseEntity<String> enableUser(Long id) {
        return updateActiveUser(id, true);
    }

    private ResponseEntity<String> updateActiveUser(Long id, boolean active) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User usr = user.get();
            usr.setActive(active);
            usr.setUpdatedAt(LocalDateTime.now());
            userRepository.save(usr);
            return active ? ResponseEntity.ok("User enable") : ResponseEntity.ok("User disabled");
        }
        return USER_NOT_FOUND;
    }
}
