import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { setPosts } from "../../state";
import PostWidget from "./PostWidget";

const PostsWidget = ({ userId, isProfile = false }) => {
  const dispatch = useDispatch();
  const posts = useSelector((state) => state.posts);
  const token = useSelector((state) => state.token);


  const getPosts = async () => {
    const response = await fetch("http://localhost:8083/api/post", {
      method: "GET",
      headers: { Authorization: `Bearer ${token}` },
    });
    const data = await response.json();
    dispatch(setPosts({ posts: data }));
  };

  const getUserPosts = async () => {
    const response = await fetch(
      `http://localhost:8083/api/post/${userId}`,
      {
        method: "GET",
        headers: { Authorization: `Bearer ${token}` },
      }
    );
    const data = await response.json();
    dispatch(setPosts({ posts: data }));
  };

  useEffect(() => {
    if (isProfile) {
      getUserPosts();
    } else {
      getPosts();
    }
  }, []); 

  return (
    <>
      {posts.map(
        ({
          id,
          userId,
          name,
          description,
          location,
          picturePath,
          postPicturePath,
          likes,
          comments

        }) => (
          <PostWidget
            key={id}
            postId={id}
            postUserId={userId}
            name={name}
            description={description}
            location={location}
            picturePath={picturePath}
            postPicturePath={postPicturePath}
            likes={likes}
            comments={comments}

          />
        )
      )}
    </>
  );
};

export default PostsWidget;