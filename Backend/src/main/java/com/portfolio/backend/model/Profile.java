
package com.portfolio.backend.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Profile implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String lastname;
    private String position; 
    private String description;
    private String image;

    public Profile() {
    }
    
    public Profile(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Profile(String name, String lastname, String position) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
    }
    
    public Profile(String name, String lastname, String position, String description, String image) {
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.description = description;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
    @Override
    public String toString(){
        return String.format("%s %s", getName(), getLastname());
    }

}
