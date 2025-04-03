/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 *
 * @author Vaio
 */
public class Weapon extends Item{
    
    private int durability, atkboost;
    private String strongAgainst, weakAgainst;
    
    public Weapon(String name, String description, String status,
                  int durability, int atkboost, String strongAgainst, String weakAgainst){
        super(name, description, status);
        this.durability = durability;
        this.atkboost = atkboost;
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
    }
    
    public int getDurability(){
        return durability;
    }
    
    public void setDurability(int a){
        durability = a;
    }
    
    public int getAtkboost(){
        return atkboost;
    }
    
    public String getStrongAgainst(){
        return strongAgainst;
    }
    
    public String getWeakAgainst(){
        return weakAgainst;
    }
    
    public void defend(){
        //defend
    }
    
}
