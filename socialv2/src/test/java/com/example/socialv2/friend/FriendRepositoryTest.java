package com.example.socialv2.friend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FriendRepositoryTest {

    @Autowired
    private FriendRepository friendRepository;

    @Test
    public void test(){
        friendRepository.existsFriend(1L,2L);
    }

}