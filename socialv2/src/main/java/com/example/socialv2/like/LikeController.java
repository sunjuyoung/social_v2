package com.example.socialv2.like;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
