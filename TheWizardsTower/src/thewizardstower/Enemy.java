/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;

/**
 *
 * @author Vaio
 */
public class Enemy extends Character {
    protected String element, strongAgainst, weakAgainst;
    protected int tier;
    protected boolean provoked;
    
    public Enemy(String name, int hp, int attack, float defense, int agility, int maxEquipped, Floor floor, Inventory inventory,
                 String strongAgainst, String weakAgainst, String element, int tier){
        super(name, hp, attack, defense, agility, maxEquipped, floor, inventory);
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
        this.element = element;
        this.tier = tier;
        provoked = false;
    }
    
    public void spawn(Surrounding s){
        //spawn enemy in a surrounding
    }
}
