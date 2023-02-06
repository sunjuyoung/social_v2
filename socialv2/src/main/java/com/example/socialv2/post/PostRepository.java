package com.example.socialv2.post;

import com.example.socialv2.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long>, PostRepositoryExtension {

    List<Post> findByUser(User user);
}
