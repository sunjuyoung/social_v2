package com.example.socialv2.user;

import com.example.socialv2.friend.FriendDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface UserRepositoryExtension {

    List<FriendDTO> findUserFriendsById(Long id);
}
