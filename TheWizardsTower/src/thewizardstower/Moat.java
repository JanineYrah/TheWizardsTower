/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;

/**
 *
 * @author Vaio
 */
public class Moat extends Obstacle {
    
    public Moat(int damage){
        super(5);
    }
    
    public void trap(Character c){
        int original = c.getAgility();
        c.setAgility(0);
    }
    
    public void drown(Character c){
        int health = c.getHp();
        while (health > 0){
            health-=damage;
        }
    }
}
