package com.example.socialv2.user;

import com.example.socialv2.friend.FriendDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(user -> userDTOS.add(modelMapper.map(user, UserDTO.class)));
        return userDTOS;
    }

    public UserDTO getUser(Long id) {
        UserDTO userDTO = userRepository.findUserAndFriendCount(id);
        return userDTO;
    }

    public List<FriendDTO>  getUserWithFriends(Long id) {
        List<FriendDTO> friendDTOS = userRepository.findUserFriendsById(id);
        return friendDTOS;

    }
}
