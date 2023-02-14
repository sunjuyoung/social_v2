package com.example.socialv2.like;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikesDTO implements Serializable {

    private long post_id;
    private long user_id;
}
