
package com.portfolio.backend.model;

public class MessageCustom implements java.io.Serializable{
     private String message;

    public MessageCustom(String message) {
        this.message = message;
    }

    public MessageCustom() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
