package com.planets.microservice_demo.UserResponses;

import com.planets.microservice_demo.models.User;
import lombok.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.net.URI;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReponse {
    private User user;
    private String link;
}
