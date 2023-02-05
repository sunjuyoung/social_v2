package com.example.socialv2.friend;

import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface FriendRepositoryExtension {

    boolean existsFriend(Long userId,Long friendId);
}
