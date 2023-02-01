package com.example.socialv2.user;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private Role role;

    private String location;

    private String occupation;

    private String picturePath;

    private int impressions;

    private int viewedProfile;

}
