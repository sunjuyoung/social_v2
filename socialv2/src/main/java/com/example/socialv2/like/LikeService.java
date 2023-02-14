package com.example.socialv2.like;

import com.example.socialv2.post.Post;
import com.example.socialv2.post.PostRepository;
import com.example.socialv2.user.User;
import com.example.socialv2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public  List<Long> getLikeByPostId(Long postId){
        List<Long> likesByPostId = likeRepository.findLikesByPostId(postId);
//        List<Long> collect = likesByPostId.stream()
//                .map(likes -> likes.getUser().getId()).collect(Collectors.toList());
//        return collect;
        return likesByPostId;

    }

    public void addLike(LikesDTO likesDTO) {
        User user = userRepository.findUserOne(likesDTO.getUser_id()).orElseThrow();
        Post post = postRepository.findById(likesDTO.getPost_id()).orElseThrow();
        likeRepository.save(new Likes(user,post));

    }

    public void deleteLike(LikesDTO likesDTO) {
        Likes likes = likeRepository.findByPostAndUser(new Post(likesDTO.getPost_id()),
                new User(likesDTO.getUser_id())).orElseThrow();
        likeRepository.delete(likes);
    }
}
