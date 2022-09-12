package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;

public class EducationDto {
    @NotBlank
    private String nameE;
    private String descriptionE;

    public EducationDto() {
    }

    public EducationDto(String nameE, String descriptionE) {
        this.nameE = nameE;
        this.descriptionE = descriptionE;
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
