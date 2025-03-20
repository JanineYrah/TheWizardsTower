/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This class represents the player character class.
 * @author Itzle
 * @version 1.0
 */

package thewizardstower;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import thewizardstower.controller.KeyHandler;

/**
 *
 * @author Itzle Alcayde
 */
public class Player extends Entity {

    /**
     * Sets the current status of the player such as game movement, current key handler and playing screen.
     * @param ps The playing screen where the player character is placed and able to play.
     * @param keyh Key handler for the player character that allows them to perform basic movement in the game.
     * @return Sum of a and b
     */
    
    PlayingScreen ps;
    KeyHandler keyh;
    
    private boolean jumping = false;
    private int jumpStrength = 10;
    private int gravity = 1;
    private int jumpVelocity = 0;
    
    public Player(PlayingScreen ps, KeyHandler keyh){
        this.ps = ps;
        this.keyh = keyh;
        setDefaultValues();
        getPlayerImage();
    }
    
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 2;
        direction = "down";
    }
    
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/had_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/had_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/had_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/had_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/had_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/had_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/had_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/had_right_2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void update(){
        
        if(keyh.upPressed == true || keyh.downPressed == true ||
           keyh.leftPressed == true || keyh.rightPressed == true){
            
            if(keyh.shiftPressed == true){
               speed = 5;
            } else if (keyh.shiftPressed == false){
                speed = 2;
            }         
            
            if (keyh.upPressed == true){
                direction = "up";
                y -= speed;
            } else if(keyh.downPressed == true){
                direction = "down";
                y += speed;
            } else if (keyh.leftPressed == true){
                direction = "left";
                x -= speed;
            } else if (keyh.rightPressed == true){
                direction = "right";
                x += speed;
            } else if (keyh.spacePressed && !jumping){
                jumping = true;
                jumpVelocity = jumpStrength;
            }
            
            spriteCounter++;
            if(spriteCounter > 20){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum ==2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            } 
        }
        if (jumping){
            y -= jumpVelocity;
            jumpVelocity -= gravity;
            
            if (y >= 100){ // Assuming ground level is at y = 100
                y = 100;
                jumping = false;
                jumpVelocity = 0;
            }
        }
    }
    
    public void draw(Graphics2D g2){
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, ps.tileSize, ps.tileSize);
        
        BufferedImage image = null;
        
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, x, y, ps.tileSize, ps.tileSize, null);
    }
}
