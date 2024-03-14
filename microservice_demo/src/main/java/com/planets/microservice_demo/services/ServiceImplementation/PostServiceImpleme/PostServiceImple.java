package com.planets.microservice_demo.services.ServiceImplementation.PostServiceImpleme;

import com.planets.microservice_demo.UserResponses.PostResponse;
import com.planets.microservice_demo.dtos.Postdto;
import com.planets.microservice_demo.exception.UserNotFoundException;
import com.planets.microservice_demo.models.Post;
import com.planets.microservice_demo.models.User;
import com.planets.microservice_demo.repositories.posts.PostRepository;
import com.planets.microservice_demo.repositories.user.UserRepository;
import com.planets.microservice_demo.services.PostInter.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class PostServiceImple implements PostService {
  private final PostRepository postRepository;
  private final ModelMapper modelMapper;
  private final UserRepository userRepository;
    @Override
    public PostResponse createPost(Integer id,Postdto postdto) {
        Post post = modelMapper.map(postdto,Post.class);
        User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id,"NotFound"));
        postRepository.save(post);
        PostResponse postResponse = new PostResponse();
        postResponse.setPost(post);
        postResponse.setUser(user);
        postResponse.setMessage("Post Created");
        return postResponse;
    }

    @Override
    public String deletePost(Integer id) {

        return null;
    }
    @Override
    public List<Post> findAll() {
        List<Post> post = postRepository.findAll();
        return post;
    }
    @Override
    public Post findPost(Integer id) {
        Post post= postRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id,"Not found"));
        return post;
    }
    @Override
    public List<Post> findUserPost(Integer id) {
   User user = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id,"Not found"));

        return user.getPostList();
    }
    @Override
    public PostResponse Update(Integer id,Postdto postdto) {
        Post post = postRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id,"Not found"));
        post.setDescription(postdto.getDescription());
        PostResponse postResponse= new PostResponse();
        postResponse.setMessage("Update succesfull");
        return postResponse;
    }
}
