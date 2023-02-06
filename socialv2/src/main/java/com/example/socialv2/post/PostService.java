package com.example.socialv2.post;

import com.example.socialv2.user.User;
import com.example.socialv2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public List<PostDTO> getPosts() {
        List<PostDTO> postDTOS = postRepository.postListWithLikeAndCommentCount();
        return postDTOS;
    }

    public void addPost(Long userId, PostDTO postDTO) {
        User user = userRepository.findUserOne(userId).orElseThrow();
        Post post = new Post(user,postDTO.getDescription());
        postRepository.save(post);
    }

    public List<PostDTO> getPostsByUserId(Long userId) {
        List<PostDTO> postDTOS = postRepository.postListWithLikeAndCommentCountByUserId(userId);
        return postDTOS;
    }

    public void updatePost(Long id, PostDTO postDTO) {
        Post post = postRepository.findById(id).orElseThrow();
        post.updateDescription(post.getDescription());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
