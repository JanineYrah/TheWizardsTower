/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import q3aa3_tau_alcayde.tolentino.gui.PlayingScreen;

/**
 *
 * @author Itzle Alcayde
 */
public class TileManager {
    PlayingScreen ps;
    Tile[] tile;
    int mapTileNum[][];
    
    public TileManager(PlayingScreen ps){
        this.ps = ps;
        tile = new Tile[10];
        mapTileNum = new int[ps.maxScreenCol][ps.maxScreenRow];
        getTileImage();
    }
    
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/had_front.png"));
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
        } catch(Exception e){
        
        }
        
    }
    
    public void draw(Graphics2D g2){
        //g2.drawImage(tile[0].image, 0, 0, ps.tileSize, ps.tileSize, null);
        int col = 0;
        int row = 0;
        int x =0;
        int y = 0;
        
        while (col < ps.maxScreenCol && row < ps.maxScreenRow){
            g2.drawImage(tile[0].image, x, y, ps.tileSize, ps.tileSize, null);
            col++;
            x += ps.tileSize;
            
            if(col == ps.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += ps.tileSize;
            }
        }
    }
}
