/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;

/**
 *
 * @author Vaio
 */
public class Spike extends Obstacle {
    
    public Spike(int d){
        super(2);
    }
    
    public void bleed(Character c){
        int health = c.getHp();
        for (int i = 1; i<=4; i++){
            health-=damage;
        }
    }
}
