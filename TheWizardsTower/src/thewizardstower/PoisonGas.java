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
public class PoisonGas extends Obstacle{
    
    public PoisonGas(int damage){
        super(3);
    }
    
    public void poison(Character c){
        double def = c.getDefense();
        c.setDefense((int) (def-0.05));
    }
    
    public void slow(Character c){
        int original = c.getAgility();
        c.setAgility(original-15);
    }
    
    public void reduceDurability(Character c){
        Inventory invetory = c.getInventory();
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
