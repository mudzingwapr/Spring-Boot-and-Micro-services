package com.planets.microservice_demo.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Integer id,String message) {

    }
}
