package com.planets.microservice_demo.UserResponses;

import com.planets.microservice_demo.models.Post;
import com.planets.microservice_demo.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Post post;
    private User user;
    private String message;
}
