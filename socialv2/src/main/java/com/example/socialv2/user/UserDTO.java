package com.example.socialv2.user;

import com.querydsl.core.annotations.QueryProjection;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private String email;

    private Role role;

    private String location;

    private String occupation;

    private String picturePath;

    private int impressions;

    private int viewedProfile;

    private int friendsCount;

    @QueryProjection
    public UserDTO(Long id, String name, String email, Role role, String location, String occupation,
                   String picturePath, int impressions, int viewedProfile, int friendsCount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.location = location;
        this.occupation = occupation;
        this.picturePath = picturePath;
        this.impressions = impressions;
        this.viewedProfile = viewedProfile;
        this.friendsCount = friendsCount;
    }
}
