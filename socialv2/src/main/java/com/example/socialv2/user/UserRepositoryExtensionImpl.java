package com.example.socialv2.user;


import com.example.socialv2.friend.FriendDTO;
import com.example.socialv2.friend.QFriends;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import org.hibernate.query.criteria.JpaExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.example.socialv2.friend.QFriends.*;
import static com.example.socialv2.user.QUser.*;


public class UserRepositoryExtensionImpl extends QuerydslRepositorySupport implements UserRepositoryExtension{

    public UserRepositoryExtensionImpl() {
        super(User.class);
    }

    @Override
    public  List<FriendDTO> findUserFriendsById(Long id) {


        List<FriendDTO> fetch = from(friends)
                .innerJoin(user).on(friends.friend.eq(user))
                .where(friends.user.id.eq(id))
                .select(Projections.fields(FriendDTO.class,
                        friends.friend.id,
                        user.email,
                        user.name,
                        user.picturePath)).fetch();


        return fetch;
    }
}
