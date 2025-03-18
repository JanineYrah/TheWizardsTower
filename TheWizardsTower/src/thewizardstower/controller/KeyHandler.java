/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.border.LineBorder;

/**
 *
 * @author Itzle Alcayde
 */
public class KeyHandler implements KeyListener {
    
    public boolean upPressed, downPressed, leftPressed, rightPressed, shiftPressed, spacePressed;
    public int counter = 0;
    
    @Override
    public void keyTyped(KeyEvent e) {
      
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode(); // get keycode of key
                
        if (code == KeyEvent.VK_W){
            upPressed = true;
        }
        
        if (code == KeyEvent.VK_A){
            leftPressed = true;
        }
        
        if (code == KeyEvent.VK_S){
            downPressed = true;
        }
        
        if (code == KeyEvent.VK_D){
            rightPressed = true;
        }
        
        if (code == KeyEvent.VK_SHIFT){
           shiftPressed = true; 
        }
        
        if (code == KeyEvent.VK_SPACE){
           spacePressed = true; 
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode(); // get keycode of key
        
        if (code == KeyEvent.VK_W){
            upPressed = false;
        }
        
        if (code == KeyEvent.VK_A){
            leftPressed = false;
        }
        
        if (code == KeyEvent.VK_S){
            downPressed = false;
        }
        
        if (code == KeyEvent.VK_D){
            rightPressed = false;
        }
        
        if (code == KeyEvent.VK_SHIFT){
           shiftPressed = false; 
        }
        
        if (code == KeyEvent.VK_SPACE){
           spacePressed = false; 
        }
    }
    
}
