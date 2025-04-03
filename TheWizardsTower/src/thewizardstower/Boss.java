/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 *
 * @author Vaio
 */
public class Boss extends Enemy {
    public Boss(String name, int hp, int attack, float defense, int agility, int maxEquipped,
                Floor floor, Inventory inventory, String strongAgainst, String weakAgainst, String element, int tier){
        super(name, hp, attack, defense, agility, maxEquipped,
              floor, inventory, strongAgainst, weakAgainst, element, tier);
        provoked = true;
    }
    
    public void specialMove(){
        
    }
}
