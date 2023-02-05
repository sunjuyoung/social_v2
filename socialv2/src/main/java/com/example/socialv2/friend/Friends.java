package com.example.socialv2.friend;

import com.example.socialv2.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "friend")
public class Friends {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id",nullable = false)
    private User friend;

    protected Friends(){

    }

    public Friends(User user, User friend){
        this.user = user;
        this.friend = friend;
    }





}
