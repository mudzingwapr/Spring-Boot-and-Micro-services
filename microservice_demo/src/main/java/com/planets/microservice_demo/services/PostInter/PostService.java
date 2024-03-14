package com.planets.microservice_demo.services.PostInter;

import com.planets.microservice_demo.UserResponses.PostResponse;
import com.planets.microservice_demo.dtos.Postdto;
import com.planets.microservice_demo.models.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
public interface PostService {
    PostResponse createPost(Integer id,Postdto postdto);
    String deletePost(Integer id);
    List<Post> findAll();
    Post findPost(Integer id);
    List<Post> findUserPost(Integer id);

    PostResponse Update(Integer id,Postdto postdto);

}
