package com.example.socialv2.friend;

import com.example.socialv2.user.User;
import com.example.socialv2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final UserRepository userRepository;

    public void addFriend(Long userId,Long friendId){
        if(friendRepository.existsFriend(userId,friendId)){
            friendRepository.deleteByFriend(new User(friendId));
        }else {
            friendRepository.save(new Friends(new User(userId),new User(friendId)));
        }

    }
}
