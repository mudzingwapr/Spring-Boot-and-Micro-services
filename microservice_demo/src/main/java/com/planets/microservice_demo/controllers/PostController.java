package com.planets.microservice_demo.controllers;

import com.planets.microservice_demo.UserResponses.PostResponse;
import com.planets.microservice_demo.dtos.Postdto;
import com.planets.microservice_demo.models.Post;
import com.planets.microservice_demo.services.PostInter.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;
    @PostMapping("/create/{id}/post")
    public ResponseEntity<PostResponse> createPost(@PathVariable ("id") Integer id,@Valid @RequestBody Postdto postdto){
        return new ResponseEntity<>(postService.createPost(id,postdto), HttpStatus.CREATED);
    }
    @GetMapping("user/{id}/posts")
    public ResponseEntity<List<Post>> getPosts(@PathVariable ("id") Integer id){
        return new ResponseEntity<>(postService.findUserPost(id),HttpStatus.OK);
    }
}
