package com.example.socialv2.like;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/like")
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<Long>> getLikeByPostId(@PathVariable("postId")Long id){
        List<Long> likeByPostId = likeService.getLikeByPostId(id);
        return ResponseEntity.ok().body(likeByPostId);
    }

    @PostMapping
    public ResponseEntity<?> addLike(@RequestBody LikesDTO likesDTO){
        likeService.addLike(likesDTO);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteLike(@RequestBody LikesDTO likesDTO){
        likeService.deleteLike(likesDTO);
        return ResponseEntity.ok().body("success");
    }



}
