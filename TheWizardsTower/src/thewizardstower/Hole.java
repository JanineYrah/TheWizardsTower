/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.util.ArrayList;
/**
 * This class represents the Hole class, which extends from the Obstacle class.
 * @author Vaio
 */
public class Hole extends Obstacle {
    
    /**
     * This refers to how deep the hole is.
     */
    
    private int depth;
    
    /**
     * This refers to the list of enemies that can be found inside the hole.
     */
    
    private ArrayList<Enemy> enemyList;
    
    /**
     * This constructor creates a new hole object.
     * @param damage The specified damage that the hole can inflict.
     * @return This constructs a new hole object, which is an obstacle that does the given amount of damage on a character.
     */
    
    public Hole(int damage){
        super(damage);
    }
    
    /**
     * This method traps a character who would fall into the hole.
     * @param character the specified character.
     * @return Returns the specified character's agility, which has been changed to 0.
     */
    
     public void trap(Character character){
        int original = character.getAgility();
        character.setAgility(0);
    }
     
     /**
     * This method may or may not inflict the damage that a character's health experiences once it falls into the hole, which depends on its depth.
     * @param character The specified character.
     * @return Returns the specified character's decreased health, which was lessened by the hole's damage amount.
     */
    
    @Override
    public void damage(Character character){
        int health = character.getHp();
        if (depth > 10){
            character.setHp(0);
        } else if (depth > 5){
            character.setHp(health-2*damage);
        } else{
            System.out.println("The character didn't take any fall damage");
        }
    }
    
    
}
