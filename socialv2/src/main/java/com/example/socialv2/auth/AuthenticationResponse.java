package com.example.socialv2.auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class AuthenticationResponse {

    private String token;

}
