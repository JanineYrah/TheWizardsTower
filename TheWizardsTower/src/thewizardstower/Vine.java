/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;

/**
 *
 * @author Vaio
 */
public class Vine extends Obstacle{
    
    public Vine(int d){
        super(0);
    }
    
    public void trap(Character c){
        int original = c.getAgility();
        c.setAgility(0);
        
        for (int i = 1; i<=10; i++){
            if (i<10){
                System.out.println("The character is trapped for " + i + " more seconds.");
            } else{
                c.setAgility(original);
                System.out.println("The character is not trapped anymore");
            }
        }
    }
    
    public void slow(Character c){
        int original = c.getAgility();
        c.setAgility(original-10);
        
        for (int i = 1; i<=5; i++){
            if (i<5){
                System.out.println("The character is slowed for " + i + " more seconds.");
            } else{
                c.setAgility(original);
                System.out.println("The slow effect is gone");
            }
        }
    }
}
