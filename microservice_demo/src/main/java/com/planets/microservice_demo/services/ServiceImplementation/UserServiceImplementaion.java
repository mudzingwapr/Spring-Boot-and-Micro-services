package com.planets.microservice_demo.services.ServiceImplementation;

import com.planets.microservice_demo.UserResponses.UserReponse;
import com.planets.microservice_demo.dtos.UserRecord;
import com.planets.microservice_demo.exception.UserNotFoundException;
import com.planets.microservice_demo.models.User;
import com.planets.microservice_demo.repositories.user.UserRepository;
import com.planets.microservice_demo.services.Interf.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
@RequiredArgsConstructor
public class UserServiceImplementaion implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelmapper;
    @Override
    public UserReponse createUser(UserRecord userRecord) {
        User user=modelmapper.map(userRecord,User.class);

        User user1= userRepository.save(user);
        UserReponse userReponse= new UserReponse();
        userReponse.setUser(user1);
        userReponse.setLink("user created");
        //EntityModel<User> entityModel=EntityModel.of(user);
        //WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(getClass()).findAll());
        //entityModel.add(webMvcLinkBuilder.withRel("all-User"));
       // userReponse.setLink(entityModel);
        return userReponse;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserReponse findUser(Integer uid) {
        User user=userRepository.findById(uid).orElseThrow(()->new UserNotFoundException(uid,"Not found"));
        //EntityModel<User> entityModel=EntityModel.of(user);
        UserReponse userReponse= new UserReponse();
        userReponse.setUser(user);
        //WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(getClass()).findAll());
        //entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        //userReponse.setLink(entityModel);
        userReponse.setLink("user with id   "+user.getUid()+"  found");
        return userReponse;
    }

    @Override
    public String deleteUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id,"Not found"));
        if(user!=null)
            userRepository.delete(user);
        return "User with id  "+user.getUid()+"  delete";
    }

    @Override
    public UserReponse UpdateUser(Integer id,UserRecord userRecord) {
       User user = userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id," Not Found"));
       user.setUname(userRecord.getUname());
       user.setAddress(userRecord.getAddress());
       userRepository.save(user);
       UserReponse userReponse= new UserReponse();
       userReponse.setUser(user);
       userReponse.setLink("User with id "+user.getUid()+" Updated");
       return userReponse;
    }
}
