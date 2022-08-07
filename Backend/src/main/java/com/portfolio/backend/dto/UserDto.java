package com.portfolio.backend.dto;

import com.sun.istack.NotNull;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

public class UserDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error length")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Error length")
    private String lastName;
    
    private String img;

}
