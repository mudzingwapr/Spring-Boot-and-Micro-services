package com.planets.microservice_demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
@Data
@Entity
@DynamicInsert
@DynamicUpdate
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer uid;
    @Size(min=3,max=20,message = "User name length must be between 3 and 20")
    private String uname;
    @Size(min=5,max=30,message = "Address length must be between 5 and 30")
    private String address;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Post> postList;
}
