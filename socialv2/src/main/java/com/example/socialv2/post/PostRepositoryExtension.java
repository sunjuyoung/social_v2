package com.example.socialv2.post;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface PostRepositoryExtension {


    List<PostDTO> postListWithLikeAndCommentCount();

    List<PostDTO> postListWithLikeAndCommentCountByUserId(Long userId);
}
