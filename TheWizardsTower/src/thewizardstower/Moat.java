/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 * This class represents the Moat class, which extends from the Obstacle class.
 * @author Vaio
 */
public class Moat extends Obstacle {
    
    /**
     * This constructor creates a new moat object.
     * @return This constructs a new vine object, which is an obstacle that can always do a damage of 5 on any character.
     */
    
    public Moat(){
        super(5);
    }
    
    /**
     * This method traps a character who would fall into the moat.
     * @param character the specified character.
     * @return Returns the specified character's agility, which has been changed to 0.
     */
    
    public void trap(Character character){
        int original = character.getAgility();
        character.setAgility(0);
    }
    
    /**
     * This method continuously decreases a character's health while they are submerged inside the moat.
     * @param character the specified character.
     * @return Returns the specified character's decreased hp by the moat's damage number for every 1 second.
     */
    
    public void drown(Character character){
        int health = character.getHp();
        while (health > 0){
            health-=damage;
        }
    }
}
