package com.example.socialv2.auth;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class AuthenticationResponse {

    private String token;
    private Map<String,String> user;

}
