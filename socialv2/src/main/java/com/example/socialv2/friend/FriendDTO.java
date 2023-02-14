package com.example.socialv2.friend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO implements Serializable {

    private Long id;
    private Long friendId;
    private String email;
    private String name;
    private String picturePath;
    private String occupation;

    public FriendDTO(Friends friends) {
        this.id = friends.getId();
        this.friendId = friends.getFriend().getId();
        this.email = friends.getFriend().getEmail();
        this.name = friends.getFriend().getName();
        this.picturePath = friends.getFriend().getPicturePath();
        this.occupation = friends.getFriend().getOccupation();
    }
}
