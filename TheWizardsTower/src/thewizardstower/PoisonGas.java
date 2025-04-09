/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.util.ArrayList;
/**
 * This class represents the Poison Gas class, which extends from the Obstacle class.
 * @author Vaio
 */
public class PoisonGas extends Obstacle{
    
    /**
     * This constructor creates a new poison gas object.
     * @return This constructs a new vine object, which is an obstacle that can always do a damage of 3 on any character.
     */
    
    public PoisonGas(){
        super(3);
    }
    
    /**
     * This method continuously damages a character's defense while they are within the poison gas's vicinity.
     * @param character The specified character.
     * @return Returns the specified character's decreased defense by 0.05 for every 1 second.
     */
    
    public void poison(Character character){
        double def = character.getDefense();
        character.setDefense((int) (def-0.05));
    }
    
    /**
     * This method slows a character while they are within the poison gas's vicinity.
     * @param character the specified character.
     * @return Returns the specified character's decreased agility by 15.
     */
    
    public void slow(Character character){
        int original = character.getAgility();
        character.setAgility(original-15);
    }
    
    /**
     * This method lowers the durability of all the specified character's weapons in their inventory.
     * @param character the specified character.
     * @return Returns a decreased durability by 1 of all weapons found in the specified character's inventory.
     */
    
    public void reduceDurability(Character character){
        Inventory invetory = character.getInventory();
        ArrayList<Item> list = invetory.getInventoryList();
        for (Item a : list){
            if (a instanceof Weapon){
                Weapon weapon = (Weapon) a;
                int durability = weapon.getDurability();
                
                weapon.setDurability(durability-1);
            }
        }
        
    }
}
