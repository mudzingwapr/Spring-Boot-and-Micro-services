package com.planets.microservice_demo.repositories.posts;

import com.planets.microservice_demo.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
