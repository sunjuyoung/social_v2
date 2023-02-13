package com.example.socialv2.post;

import com.example.socialv2.comment.QComment;
import com.example.socialv2.like.QLikes;
import com.example.socialv2.user.QUser;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.example.socialv2.comment.QComment.*;
import static com.example.socialv2.like.QLikes.*;
import static com.example.socialv2.post.QPost.*;
import static com.example.socialv2.user.QUser.*;

public class PostRepositoryExtensionImpl extends QuerydslRepositorySupport implements PostRepositoryExtension {

    public PostRepositoryExtensionImpl() {
        super(Post.class);
    }

    @Override
    public List<PostDTO> postListWithLikeAndCommentCount() {
        JPQLQuery<PostDTO> result = getPostDTOJPQLQuery();
        return result.fetch();
    }

    @Override
    public List<PostDTO> postListWithLikeAndCommentCountByUserId(Long userId) {
        JPQLQuery<PostDTO> result = getPostDTOJPQLQuery();
        result.where(user.id.eq(userId));
        return result.fetch();
    }



    private JPQLQuery<PostDTO> getPostDTOJPQLQuery() {
        JPQLQuery<PostDTO> result = from(post)
                .innerJoin(post.user, user)
                .leftJoin(comment).on(comment.post.eq(post))
                .leftJoin(likes).on(likes.post.eq(post))
                .groupBy(post.id)
                .limit(50)
                .select(new QPostDTO(
                        post.id,
                        user.name,
                        post.description,
                        user.location,
                        user.picturePath,
                        likes.countDistinct().intValue(),
                        comment.countDistinct().intValue(),
                        post.postPicturePath
                ));
        return result;
    }

}
