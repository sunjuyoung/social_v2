package com.example.socialv2.post;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts(){
        List<PostDTO> postDTOS = postService.getPosts();
        return ResponseEntity.ok().body(postDTOS);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable("userId")Long userId){
        List<PostDTO> postDTOS = postService.getPostsByUserId(userId);
        return ResponseEntity.ok().body(postDTOS);
    }
    @GetMapping("/get/{postId}")
    public ResponseEntity<PostDTO> getPostsByPostId(@PathVariable("postId")Long postId){
        PostDTO postDTO = postService.getPostsByPostId(postId);
        return ResponseEntity.ok().body(postDTO);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<?> addPost(@PathVariable("userId")Long userId,
                                     @RequestBody PostDTO postDTO){
        postService.addPost(userId, postDTO);
       // List<PostDTO> postDTOS = postService.getPosts();
        return ResponseEntity.ok().body("success");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable("id")Long id,
                                     @RequestBody PostDTO postDTO){
        postService.updatePost(id,postDTO);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable("id")Long id){
        postService.deletePost(id);
        return ResponseEntity.ok().body("success");
    }
}
