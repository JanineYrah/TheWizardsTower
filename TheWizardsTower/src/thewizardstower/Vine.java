/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

/**
 * This class represents the Vine class, which extends from the Obstacle class.
 * @author Vaio
 */
public class Vine extends Obstacle{
    
    /**
     * This constructor creates a new vine object.
     * @return This constructs a new vine object, which is an obstacle that does not do any damage on the Character.
     */
    
    public Vine(){
        super(0);
    }
    
    /**
     * This method temporarily traps a character within the vine's clutches for 10 seconds.
     * @param character the specified character.
     * @return Returns a countdown from 10 seconds where the specified character will be trapped until they are freed.
     */
    
    public void trap(Character character){
        int original = character.getAgility();
        character.setAgility(0);
        
        for (int i = 1; i<=10; i++){
            if (i<10){
                System.out.println("The character is trapped for " + i + " more seconds.");
            } else{
                character.setAgility(original);
                System.out.println("The character is not trapped anymore");
            }
        }
    }
    
    /**
     * This method temporarily slows a character for 5 seconds by decreasing their agility.
     * @param character the specified character.
     * * @return Returns a countdown from 5 seconds where the specified character will be slowed until the effect is removed.
     */
    
    public void slow(Character character){
        int original = character.getAgility();
        character.setAgility(original-10);
        
        for (int i = 1; i<=5; i++){
            if (i<5){
                System.out.println("The character is slowed for " + i + " more seconds.");
            } else{
                character.setAgility(original);
                System.out.println("The slow effect is gone");
            }
        }
    }
}
