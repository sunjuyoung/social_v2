package com.example.socialv2.like;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public  List<Long> getLikeByPostId(Long postId){
        List<Long> likesByPostId = likeRepository.findLikesByPostId(postId);
//        List<Long> collect = likesByPostId.stream()
//                .map(likes -> likes.getUser().getId()).collect(Collectors.toList());
//        return collect;
        return likesByPostId;

    }
}
