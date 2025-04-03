/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package thewizardstower;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import thewizardstower.controller.KeyHandler;

/**
 * This class represents the player character class.
 * @author Itzle
 */
public class Player extends Entity {

    /**
     * Sets the current status of the player such as game movement, current key handler and playing screen.
     */
    
    PlayingScreen ps;
    KeyHandler keyh;
    
    private boolean jumping = false;
    private int jumpStrength = 10;
    private int gravity = 1;
    private int jumpVelocity = 0;

     /**
     * @param ps The playing screen where the player character is placed and able to play.
     * @param keyh Key handler for the player character that allows them to perform basic movement in the game.
     * @return This constructs a new player that belongs in a playing screen and has a keyhandler.
     * @param g2 Is a Graphics2D parameter that allows the Player character sprite image to be updated
     */
    
    public Player(PlayingScreen ps, KeyHandler keyh){
        this.ps = ps;
        this.keyh = keyh;
        setDefaultValues();
        getPlayerImage();
    }

     /**
     * This sets the default stats and position of the player's character.
     * @return This returns the default set values of the player's position, speed and direction.
     */
    
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 2;
        direction = "down";
    }

    /**
     * This method gets the image files of the player character sprite from the assets folder to use them in the following methods.
     * @return Returns the player image from the assets folder that contains the image sprites of the player/
     */
    
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/assets/player/had_right_2.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method allows the player to update their movemend based on the key that they pressed, that can change speed and direction.
     * @return Returns updates to the keyhadler if the player has pressed keys on their keboard, and updates the player character's movement.
     */
    
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

    /**
     * This allows the sprite images of the player to be drawn and changed to create moving animations and directions based on the key that they pressed.
     * @param g2 Is a Graphics2D parameter that allows the Player character sprite image to be updated
     * @return Reutrns and draws the correct immage sprite of the player character when it moves to different directions.
     */
    
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
