package com.planets.microservice_demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="post_tab")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer pid;
    @Size(min=10,max=50,message = "Description must be between 10 to 50 characters")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
