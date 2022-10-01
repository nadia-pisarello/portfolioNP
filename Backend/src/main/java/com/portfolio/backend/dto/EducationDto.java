package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;

public class EducationDto {
    @NotBlank
    private String title;
    private String institution;
    private String descriptionE;

    public EducationDto() {
    }

    public EducationDto(String title, String institution,String descriptionE) {
        this.title = title;
        this.institution = institution;
        this.descriptionE = descriptionE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
    
    
}
