import { Box } from "@mui/material";


const UserImage = ({ image, size = "60px" }) => {
  
    const imgUrl = new URL(`../assets/${image}`, import.meta.url).href;


  return (
    <Box width={size} height={size}>
      <img
        style={{ objectFit: "cover", borderRadius: "50%" }}
        width={size}
        height={size}
        alt="user"
        src={imgUrl}
      />
    </Box>
  );
};

export default UserImage;