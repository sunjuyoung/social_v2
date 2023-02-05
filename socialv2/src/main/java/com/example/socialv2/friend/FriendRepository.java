package com.example.socialv2.friend;

import com.example.socialv2.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FriendRepository extends JpaRepository<Friends,Long>, FriendRepositoryExtension {

    void deleteByFriend(User friend);
}
