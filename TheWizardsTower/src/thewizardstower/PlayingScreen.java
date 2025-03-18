/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;

import thewizardstower.controller
import entity.Player;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import tile.TileManager;
/**
 *
 * @author Itzle Alcayde
 */
public class PlayingScreen extends JPanel implements Runnable{
    //Screen tile settings
    private JLabel guide;
    final int originalTileSize = 40; //Tile size 20x20 pixels
    final int scale = 3; //Scales tile
    public final int tileSize = originalTileSize * scale; // Makes tile 40x40
    
    //Screen size settings
    public final int maxScreenCol = 10;
    public final int maxScreenRow = 6;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    
    //TileManager tilem = new TileManager(this);
    KeyHandler keyh = new KeyHandler();
    
    //Set player default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    
    Thread gameThread;
    int FPS = 60;
    Player player = new Player(this, keyh);
    
    public PlayingScreen(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.guide = new JLabel();
        guide.setText("Press W, A, S, D to move: up, left, down and right");
        guide.setForeground(Color.WHITE);
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        
        while (gameThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime-lastTime)/drawInterval;
            lastTime = currentTime;
            
            if (delta >= 1){
                update(); //UPDATE components            
                repaint(); //DRAW updated compoentns
                delta--;
            }
        }        
    }
    
    public void update(){
        player.update();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //tilem.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
