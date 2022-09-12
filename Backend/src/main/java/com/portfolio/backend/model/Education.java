package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameE;
    private String descriptionE;

    //Constructor
    public Education() {
    }

    public Education(String nameE, String descriptionE) {
        this.nameE = nameE;
        this.descriptionE = descriptionE;
    }
    
    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
    
    
}
