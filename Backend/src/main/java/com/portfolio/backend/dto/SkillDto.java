package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillDto {
    
    @NotBlank
    private String tech;
    private byte[] image;

    public SkillDto() {
    }

    public SkillDto(String tech, byte[] image) {
        this.tech = tech;
        this.image = image;
    }
    
}
