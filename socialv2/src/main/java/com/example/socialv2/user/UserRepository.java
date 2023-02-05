package com.example.socialv2.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryExtension {

    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = {"friends"})
    Optional<User> findUserAndFriendsById(Long id);


}
