package com.example.socialv2.post;

import com.example.socialv2.comment.Comment;
import com.example.socialv2.common.BaseTime;
import com.example.socialv2.like.Likes;
import com.example.socialv2.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String description;

    @OneToMany(mappedBy = "post")
    private Set<Likes> likes = new HashSet<>();

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    private String postPicturePath;

    protected Post(){

    }

    public Post(Long id){
        this.id = id;
    }
    public Post(User user, String description, String postPicturePath) {
        this.user = user;
        this.description = description;
        this.postPicturePath = postPicturePath;
    }

    public void updateDescription(String description){
        this.description = description;
    }
}
