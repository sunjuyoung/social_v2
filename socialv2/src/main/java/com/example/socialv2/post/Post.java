package com.example.socialv2.post;

import com.example.socialv2.common.BaseTime;
import com.example.socialv2.like.Likes;
import com.example.socialv2.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
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
    private List<Likes> likes = new ArrayList<>();

    private String postPicturePath;

    public Post(User user, String description, String postPicturePath) {
        this.user = user;
        this.description = description;
        this.postPicturePath = postPicturePath;
    }

    public void updateDescription(String description){
        this.description = description;
    }
}
