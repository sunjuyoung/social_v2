package com.example.socialv2.post;

import com.example.socialv2.user.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>, PostRepositoryExtension {

    List<Post> findByUser(User user);

    @EntityGraph(attributePaths = {"user","likes"})
    List<Post> findAll();


}
