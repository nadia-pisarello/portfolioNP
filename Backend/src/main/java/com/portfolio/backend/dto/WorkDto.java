
package com.portfolio.backend.dto;

import javax.validation.constraints.NotBlank;

public class WorkDto {
    @NotBlank
    private String xpName;
    @NotBlank
    private String descripXp; 
    //constructor

    public WorkDto() {
    }

    public WorkDto(String xpName, String descripXp) {
        this.xpName = xpName;
        this.descripXp = descripXp;
    }
// getters & setters
    public String getXpName() {
        return xpName;
    }

    public void setXpName(String xpName) {
        this.xpName = xpName;
    }

    public String getDescripXp() {
        return descripXp;
    }

    public void setDescripXp(String descripXp) {
        this.descripXp = descripXp;
    }
    
}
