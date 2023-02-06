package com.example.socialv2.friend;

import com.querydsl.core.Tuple;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.example.socialv2.friend.QFriends.*;

public class FriendRepositoryExtensionImpl extends QuerydslRepositorySupport implements FriendRepositoryExtension {

    public FriendRepositoryExtensionImpl() {
        super(Friends.class);
    }

    @Override
    public boolean existsFriend(Long userId, Long friendId) {
        return from(friends)
                .where(friends.user.id.eq(userId).and(friends.friend.id.eq(friendId)))
                .select(friends.id).fetchFirst() != null;
    }
}
