/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mathi
 */
public class bookNoDB {
    private String type ;
    private int pages;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSound() {
        return pages;
    }

    public void setSound(int sound) {
        this.pages = sound;
    }

    public bookNoDB(String type, int pages) {
        this.type = type;
        this.pages = pages;
    }
    
    
    
}
