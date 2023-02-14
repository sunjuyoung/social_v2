package com.example.socialv2.post;

import com.example.socialv2.user.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long>, PostRepositoryExtension {

    List<Post> findByUser(User user);

    @EntityGraph(attributePaths = {"user","likes","comments"})
    List<Post> findAll();

    @EntityGraph(attributePaths = {"user","likes","comments"})
    Optional<Post> findAllById(Long postId);

    @Query("select p.id from Post p where p.id = :id")
    Optional<Post> findPostOne(@Param("id")long id);


}
