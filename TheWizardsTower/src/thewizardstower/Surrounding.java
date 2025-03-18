/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.util.ArrayList;
/**
 *
 * @author Vaio
 */
public class Surrounding extends Floor {
    
    private ArrayList<Item> itemList;
    private ArrayList<Obstacle> obstacleList;
    private ArrayList<String> puzzleList;
    private static int[][] Array = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,8,0,0}};
    
    
    public Surrounding(ArrayList<String> E, ArrayList<Character> C, ArrayList<Enemy> e, String s, ArrayList<Item> I, ArrayList<Obstacle> O, ArrayList<String> S){
        super("", "", E,C,e,s);
        itemList = I;
        obstacleList = O;
        puzzleList = S;
    }
    
    public ArrayList<Item> getItemList(){
        return itemList;
    }
    
    public ArrayList<Obstacle> getObstacleList(){
        return obstacleList;
    }
    
    public ArrayList<String> getPuzzleList(){
        return puzzleList;
    }
    
    public static int[][] getArray(){
        return Array;
    }
    
    public void setArray(int[][] array){
        Array = array;
    }
}
