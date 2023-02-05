package com.example.socialv2.friend;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendDTO implements Serializable {

    private Long id;
    private String email;
    private String name;
    private String picture_path;
}
