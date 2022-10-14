
package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProyectDto {
    @NotBlank
    private String title;
    private String description;
    private String image;
    
    //constructor

    public ProyectDto() {
    }

    public ProyectDto(String title, String description, String image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }
    
}
