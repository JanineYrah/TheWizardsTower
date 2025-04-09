/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 * This class represents the Obstacle class.
 * @author Vaio
 */
public class Obstacle {
    
    /**
     * This refers to the amount of damage that the object can inflict on a character.
     */
    
    protected int damage;
    
    /**
     * This constructor creates a new vine object.
     * @param damage A specified number that decreases from a character's health.
     * @return This constructs a new obstacle object that is able to inflict a specified amount of damage to a character.
     */
    
    public Obstacle(int damage){
        damage = damage;
    }
    
    /**
     * This method gets the damage number of the obstacle.
     * @return Returns the amount of damage that the obstacle can inflict.
     */
    
    public int getDamage(){
        return damage;
    }
    
    /**
     * This method inflicts the Obstacle's damage to a character that comes into contact with it.
     * @param character The specified character.
     * @return Returns the specified character's decreased health, which was lessened by the obstacle's damage amount.
     */
    
    public void damage(Character character){
        int health = character.getHp();
        health -= damage;
    }
    
    /**
     * This method lets the obstacle block the character upon collision with it.
     * @param character The specified character.
     * @return Stops the player from moving during collision
     */
    
    public void block(Character character){
        //block character
    }
}
