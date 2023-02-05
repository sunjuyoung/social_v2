package com.example.socialv2.friend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/friend")
public class FriendController {

    private final FriendService friendService;

    @PostMapping("/{userId}/{friendId}")
    public ResponseEntity<?> addFriend(@PathVariable("userId")Long userId,
                                       @PathVariable("friendId")Long friendId){
        friendService.addFriend(userId,friendId);
        return ResponseEntity.ok().body("success");
    }

}
