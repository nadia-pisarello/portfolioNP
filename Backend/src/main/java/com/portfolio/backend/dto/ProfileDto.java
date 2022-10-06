package com.portfolio.backend.dto;

import java.io.Serializable;
import javax.validation.constraints.*;
import lombok.*;

@Getter @Setter
public class ProfileDto implements Serializable {
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    
    private String position;
    private String description;

    public ProfileDto() {
    }

    public ProfileDto(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
    
    
    public ProfileDto(String name, String lastname, String position) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
    }

    public ProfileDto(String name, String lastname, String position, String description) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.description = description;
    }
    

    
}
