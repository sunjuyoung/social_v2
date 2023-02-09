package com.example.socialv2.user;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryExtension {

    Optional<User> findByEmail(String email);

    @EntityGraph(attributePaths = {"friends"})
    Optional<User> findUserAndFriendsById(Long id);

    @Query("select u.id from User u where u.id = :id")
    Optional<User> findUserOne(@Param("id")Long id);

    boolean existsByEmail(String email);

    boolean existsByName(String name);


}
