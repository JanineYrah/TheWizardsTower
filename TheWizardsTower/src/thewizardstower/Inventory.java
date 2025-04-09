/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.util.ArrayList;

/**
 * This class represents the Inventory class that all characters and entities implement.
 * @author Vaio
 */
public class Inventory {
    
    /**
     * This refers to the list of items found in an inventory.
     */
    
    private ArrayList<Item> inventory;
    
    /**
     * This refers to the number that dictates the maximum number of items that an inventory can hold.
     */
    
    private int maxCapacity;
    
    /**
     * This constructor creates a new inventory object.
     * @param item an Item object that is added to the inventory.
     * @param maxCapacity an integer that dictates the maximum number of items that the inventory can hold.
     * * @return This constructs a new Inventory with an initial item added into it.
     */
    
    public Inventory (Item item, int maxCapacity){
        inventory.add(item);
        this.maxCapacity = maxCapacity;
    }
    
    /**
     * This method gets the list of items found in the inventory.
     * @return Returns the list of items found in the given inventory object.
     */
    public ArrayList<Item> getInventoryList(){
        return inventory;
    }
    
    /**
     * This method gets the maximum capacity of the inventory.
     * @return Returns the maximum number of items that the given inventory object can hold.
     */
    public int getMaxCapacity(){
        return maxCapacity;
    }
}
