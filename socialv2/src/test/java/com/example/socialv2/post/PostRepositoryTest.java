package com.example.socialv2.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {


    @Autowired
    private PostRepository postRepository;


    @Test
    public void test(){

        List<Post> posts = postRepository.findAll();
    }
}