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
        //엔티티 조회
        User user = userRepository.findById(userId).orElseThrow();
        User friendUser = userRepository.findById(friendId).orElseThrow();

        if(friendRepository.existsFriend(userId,friendId)){
            friendRepository.deleteByFriend(friendUser);
        }else {
            friendRepository.save(new Friends(user,friendUser));
        }


    }
}
