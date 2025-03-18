/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;

/**
 *
 * @author Vaio
 */
public class Potion extends Item {
    
    private boolean used;
    private String type;
    private int specialEffect;
    
    public Potion(String name, String description, String status, int specialEffect){
        super(name, description, status);
        used = false;
        this.specialEffect = specialEffect;
    }
    
    public String getType(){
        return type;
    }
    
    public int getSpecialEffect(){
        return specialEffect;
    }
}
