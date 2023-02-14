import {
    ChatBubbleOutlineOutlined,
    FavoriteBorderOutlined,
    FavoriteOutlined,
    ShareOutlined,
  } from "@mui/icons-material";
  import { Box, Divider, IconButton, Typography, useTheme } from "@mui/material";
  import FlexBetween from "../../components/FlexBetween";
  import Friend from "../../components/Friend";
  import WidgetWrapper from "../../components/WidgetWrapper";
  import { useEffect, useState } from "react";
  import { useDispatch, useSelector } from "react-redux";
  import { setPost } from "../../state";


  const PostWidget = ({
    postId,
    postUserId,
    name,
    description,
    location,
    picturePath,
    postPicturePath,
    likes,
    comments,
  }) => {
    
    const [isComments, setIsComments] = useState(false);
    const dispatch = useDispatch();
    const token = useSelector((state) => state.token);

    const loggedInUserId = useSelector((state) => state.user.id);
    const postPicPath = new URL(`../../assets/${name}/${postPicturePath}`, import.meta.url).href;
    
  
    const isLiked = likes?.includes(parseInt(loggedInUserId));
   // const isLiked = Boolean(likes[loggedInUserId]);

   // const likeCount = Object.keys(likes).length;
    const likeCount = likes.length;

    const { palette } = useTheme();
    const main = palette.neutral.main;
    const primary = palette.primary.main;

    const getPosts = async () => {
      const response = await fetch(`http://localhost:8083/api/post/get/${postId}`, {
        method: "GET",
        headers: { Authorization: `Bearer ${token}` },
      });
      const updatedPost = await response.json();
      dispatch(setPost({ post: updatedPost }));
    };

  
    const patchLike = async () => {
      const response =  await fetch(`http://localhost:8083/api/like`, {
        method: isLiked? "DELETE" : "POST",
        headers: {
          Authorization: `Bearer ${token}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ user_id: loggedInUserId ,post_id:postId}),
      });
      await response.text();
      getPosts();
    };
  
    return (
      <WidgetWrapper m="2rem 0">
        <Friend
          friendId={postUserId}
          name={name}
          subtitle={location}
          userPicturePath={`${name}/${picturePath}`}
        />
        <Typography color={main} sx={{ mt: "1rem" }}>
          {description}
        </Typography>
        {postPicturePath && (
          <img
            width="100%"
            height="auto"
            alt="post"
            style={{ borderRadius: "0.75rem", marginTop: "0.75rem" }}
            src={postPicPath}
          />
        )}
        <FlexBetween mt="0.25rem">
          <FlexBetween gap="1rem">
            <FlexBetween gap="0.3rem">
              <IconButton onClick={patchLike}>
                {isLiked ? (
                  <FavoriteOutlined sx={{ color: primary }} />
                ) : (
                  <FavoriteBorderOutlined />
                )}
              </IconButton>
              <Typography>{likeCount}</Typography>
            </FlexBetween>
  
            <FlexBetween gap="0.3rem">
              <IconButton onClick={() => setIsComments(!isComments)}>
                <ChatBubbleOutlineOutlined />
              </IconButton>
              <Typography>{comments?.length}</Typography>
            </FlexBetween>
          </FlexBetween>
  
          <IconButton>
          
            <ShareOutlined />
          </IconButton>
        </FlexBetween>
        {isComments && (
          <Box mt="0.5rem">
            {comments?.map((comment, i) => (
              <Box key={`${name}-${i}`}>
                <Divider />
                <Typography sx={{ color: main, m: "0.5rem 0", pl: "1rem" }}>
                  {comment.description}
                </Typography>
              </Box>
            ))}
            <Divider />
          </Box>
        )} 
      </WidgetWrapper>
    );
  };
  
  export default PostWidget;