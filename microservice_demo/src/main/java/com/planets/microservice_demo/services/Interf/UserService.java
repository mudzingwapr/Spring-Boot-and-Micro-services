package com.planets.microservice_demo.services.Interf;

import com.planets.microservice_demo.UserResponses.UserReponse;
import com.planets.microservice_demo.dtos.UserRecord;
import com.planets.microservice_demo.models.User;

import java.util.List;

public interface UserService {
    UserReponse createUser(UserRecord userRecord);
    List<User> findAll();
    UserReponse findUser(Integer uid);
    String deleteUser(Integer id);
    UserReponse UpdateUser(Integer id,UserRecord userRecord);

}
