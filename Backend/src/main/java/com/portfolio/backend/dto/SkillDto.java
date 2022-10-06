package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillDto {
    
    @NotBlank
    private String name;
    private String image;

    public SkillDto() {
    }

    public SkillDto(String name, String image) {
        this.name = name;
        this.image = image;
    }
    
}
