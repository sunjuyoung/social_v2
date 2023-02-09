package com.example.socialv2.auth;

import com.example.socialv2.config.JwtService;
import com.example.socialv2.user.Role;
import com.example.socialv2.user.User;
import com.example.socialv2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .occupation(request.getOccupation())
                .location(request.getLocation())
                .picturePath(request.getPicturePath())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.MEMBER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }



    /*
    AuthenticationManager는 Interface로 되어있고 authenticate(Authentication authentication)메소드만 정의되어 있다.
    리턴타입은 Authentication으로 되어있는데 이것은 authenticate()를 실행하여 authenticationProvider객체를 통해
    인증이 완료되면 인증된 Authentication객체를 반환하는 기능을 한다는 것이다.

    **/
    /*
    UsernamePasswordAuthenticationToken은 AbstractAuthenticationToken을 상속 받는다.
    AbstractAuthenticationToken은 Authentication을 상속받는다
    즉, UsernamePasswordAuthenticationToken은 추후 인증이 끝나고
    SecurityContextHolder.getContext()에 등록될 Authentication 객체이다

    UsernamePasswordAuthenticationToken 의 2개의 생성자는 각각
    setAuthenticated(false), setAuthenticated(true)를 실행한다.

    현재(로그인 요청) 생성한 객체는 setAuthenticated(false);가 있는 생성자를 호출하는것을 볼 수 있다.
    즉, 아직 인증되지 않은 Authentication객체를 생성한 것이고


    jwt토큰  인증이 완료되면 인증된 생성자로 Authentication객체가 생성
    .*/
    public AuthenticationResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        Map<String,String> currentUser = new HashMap<>();
        currentUser.put("id",user.getId().toString());
        currentUser.put("name",user.getName());
        currentUser.put("email",user.getEmail());
        currentUser.put("location",user.getLocation());
        currentUser.put("picturePath",user.getPicturePath());
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .user(currentUser)
                .build();
    }
}
