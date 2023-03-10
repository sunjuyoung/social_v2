package com.example.socialv2.like;

import com.example.socialv2.post.Post;
import com.example.socialv2.user.User;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Likes,Long> {

    @EntityGraph(attributePaths ={"user","post"} )
    @Query("select l.user.id from Likes l where l.post.id = :postId")
    List<Long> findLikesByPostId(@Param("postId")Long postId);

    @EntityGraph(attributePaths ={"user","post"} )
    @Query("select l.post.id,l.user.id from Likes l ")
    List<LikesDTO> findLikes();

    Optional<Likes> findByPostAndUser(Post post, User user);
}
