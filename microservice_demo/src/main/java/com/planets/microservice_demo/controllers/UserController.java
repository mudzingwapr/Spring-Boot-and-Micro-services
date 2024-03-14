package com.planets.microservice_demo.controllers;

import com.planets.microservice_demo.UserResponses.UserReponse;
import com.planets.microservice_demo.dtos.UserRecord;
import com.planets.microservice_demo.models.User;
import com.planets.microservice_demo.services.Interf.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class UserController {
    private final UserService  userService;
    @PostMapping("/create")
    public ResponseEntity<UserReponse> createUser(@Valid @RequestBody UserRecord userRecord){
        return new ResponseEntity<>(userService.createUser(userRecord), HttpStatus.CREATED);
    }
@GetMapping("/find-all")
    public ResponseEntity<List<User>> findUsers(){
                return new ResponseEntity<List<User>>(userService.findAll(),HttpStatus.MULTI_STATUS);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<UserReponse> findUser(@PathVariable ("id") Integer id){
       return new ResponseEntity<>(userService.findUser(id),HttpStatus.OK);
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable ("id") Integer id){
       return new  ResponseEntity<>( userService.deleteUser(id),HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserReponse> updateUser(@PathVariable ("id") Integer id,@Valid @RequestBody UserRecord userRecord){
        return new ResponseEntity<>(userService.UpdateUser(id,userRecord),HttpStatus.OK);
    }
}
