package com.example.socialv2.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userservice;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userservice.getUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id")Long id){
        return ResponseEntity.ok(userservice.getUser(id));
    }
}
