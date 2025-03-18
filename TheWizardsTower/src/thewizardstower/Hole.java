/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;
import java.util.ArrayList;
/**
 *
 * @author Vaio
 */
public class Hole extends Obstacle {
    
    private int depth;
    private ArrayList<Enemy> enemyList;
    
    public Hole(int damage){
        super(damage);
    }
    
     public void trap(Character c){
        int original = c.getAgility();
        c.setAgility(0);
    }
    
    @Override
    public void damage(Character c){
        int health = c.getHp();
        if (depth > 10){
            c.setHp(0);
        } else if (depth > 5){
            c.setHp(health-2*damage);
        } else{
            System.out.println("The character didn't take any fall damage");
        }
    }
    
    
}
