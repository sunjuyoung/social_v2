package com.example.socialv2.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest implements Serializable {

    private String name;
    private String password;
    private String email;
    private String location;
    private String occupation;
    private String picturePath;
}
