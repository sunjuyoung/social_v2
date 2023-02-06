package com.example.socialv2.post;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PostDTO implements Serializable {

    private Long id;
    private String name;
    private String description;

    private String location;
    private String picturePath;

    private int likeCount;

    private int commentCount;


    public PostDTO(Post post) {
        this.id = post.getId();
        this.name = post.getUser().getName();
        this.description = post.getDescription();
        this.picturePath = post.getUser().getPicturePath();
    }

    @QueryProjection
    public PostDTO(Long id, String name, String description, String location,
                   String picturePath, int likeCount, int commentCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.picturePath = picturePath;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }
}
