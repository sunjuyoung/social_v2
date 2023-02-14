package com.example.socialv2.post;

import com.example.socialv2.comment.CommentDTO;
import com.example.socialv2.like.Likes;
import com.example.socialv2.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class PostDTO implements Serializable {

    private Long id;
    private String name;
    private String description;

    private String location;
    private String picturePath;
    private String postPicturePath;

    private int likeCount;

    private List<Long> likes = new ArrayList<>();

    private int commentCount;

    private List<CommentDTO> comments = new ArrayList<>();


    public PostDTO(Post post) {
        this.id = post.getId();
        this.name = post.getUser().getName();
        this.description = post.getDescription();
        this.location = post.getUser().getLocation();
        this.picturePath = post.getUser().getPicturePath();
        this.postPicturePath = post.getPostPicturePath();
        this.likes = post.getLikes().stream()
                .map((l -> l.getUser().getId())).collect(Collectors.toList());
        post.getComments().forEach(comment ->
                this.comments.add(new CommentDTO(comment)));

    }

    @QueryProjection
    public PostDTO(Long id, String name, String description, String location,
                   String picturePath, int likeCount, int commentCount, String postPicturePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.picturePath = picturePath;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
        this.postPicturePath = postPicturePath;

    }
}
