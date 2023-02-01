package com.example.socialv2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();


    }

    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();

    }
}
