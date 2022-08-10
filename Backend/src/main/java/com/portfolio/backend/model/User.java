package com.portfolio.backend.model;

import com.sun.istack.NotNull;
import javax.persistence.*;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
//@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error length")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error length")
    private String lastName;
    
    private String image;

}

