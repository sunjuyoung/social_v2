package com.example.socialv2.friend;

import com.example.socialv2.user.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FriendRepository extends JpaRepository<Friends,Long>, FriendRepositoryExtension {

    void deleteByFriend(User friend);

    @EntityGraph(attributePaths = {"friend"})
    List<Friends> findByUser(User user);
}
