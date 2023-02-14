package com.example.socialv2.friend;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/{userId}")
    public ResponseEntity<List<FriendDTO>> getFriendsByUserId(@PathVariable("userId")Long userId){
        List<FriendDTO> friendDTOS = friendService.getFriendsByUserId(userId);
        return ResponseEntity.ok().body(friendDTOS);
    }

}
