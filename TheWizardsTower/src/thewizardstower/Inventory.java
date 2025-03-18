/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.util.ArrayList;

/**
 *
 * @author Vaio
 */
public class Inventory {
    private ArrayList<Item> inventory;
    private int maxCapacity;
    
    public Inventory (Item item, int maxCapacity){
        inventory.add(item);
        this.maxCapacity = maxCapacity;
    }
    
    public ArrayList<Item> getInventoryList(){
        return inventory;
    }
    
    public int getMaxCapacity(){
        return maxCapacity;
    }
}
