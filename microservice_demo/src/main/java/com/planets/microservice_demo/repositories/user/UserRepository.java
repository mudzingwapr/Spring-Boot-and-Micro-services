package com.planets.microservice_demo.repositories.user;

import com.planets.microservice_demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
