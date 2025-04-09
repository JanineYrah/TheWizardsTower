/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 * This class represents the Spike class, which extends from the Obstacle class.
 * @author Vaio
 */
public class Spike extends Obstacle {
    
    /**
     * This constructor creates a new spike object.
     * @return This constructs a new vine object, which is an obstacle that can always do a damage of 2 on any character.
     */
    
    public Spike(){
        super(2);
    }
    
    /**
     * This method continuously decreases a character's health upon collision with the spike.
     * @param character the specified character.
     * @return Returns the specified character's decreased hp by the spike's damage number for 4 seconds.
     */
    
    public void bleed(Character character){
        int health = character.getHp();
        for (int i = 1; i<=4; i++){
            health-=damage;
        }
    }
}
