/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 *
 * @author Vaio
 */
public class Obstacle {
    protected int damage;
    
    public Obstacle(int d){
        damage = d;
    }
    
    public int getDamage(){
        return damage;
    }
    
    public void damage(Character c){
        int health = c.getHp();
        health -= damage;
    }
    
    public void block(){
        //block character
    }
}
