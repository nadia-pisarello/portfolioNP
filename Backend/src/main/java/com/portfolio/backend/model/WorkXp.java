package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WorkXp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int xpId;
    private String xpName;
    private String descripXp;
    
    //constructor

    public WorkXp() {
    }

    public WorkXp(String xpName, String descripXp) {
        this.xpName = xpName;
        this.descripXp = descripXp;
    }
    
    //getters & setters

    public int getXpId() {
        return xpId;
    }

    public void setXpId(int xpId) {
        this.xpId = xpId;
    }

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
