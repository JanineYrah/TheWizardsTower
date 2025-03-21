/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class represents the floor class.
 * @author Yrah
 */
public class Floor {
    
    /**
     * Creates a new Floor level instant
     */
    
    protected ArrayList<String> elementList;
    protected ArrayList<Character> characterList;
    protected ArrayList<Enemy> enemyList;
    protected String stage, description;
    protected static String name;
    protected boolean conquered;
    private static ArrayList<Floor> floorList = new ArrayList();
    
    /**
     * @param name The name of the floor
     * @param description The given description for the floor
     * @param elementList The list of elements found in the floor, which dictates the type of items, weapons, and enemies found in the floor
     * @param characterList The list of characters currently found in the floor
     * @param enemyList The list of enemies currently found in the floor
     * @param Stage The current stage of the floor
     */
    
    public Floor(String name, String description, ArrayList<String> elementList,
            ArrayList<Character> characterList, ArrayList<Enemy> enemyList, String stage){
        this.name = name;
        this.description = description;
        this.elementList = elementList;
        this.characterList = characterList;
        this.enemyList = enemyList;
        this.stage = stage;
        conquered = false;
                floorList.add(this);
    }
    
    /**
     * This gets the name of the Floor
     * @return This returns the floor name
     */
    
    public String getName(){
        return name;
    }
    
    /**
     * This gets the Description of the floor
     * @return This returns the floor description
     */

    public String getDescription(){
        return description;
    }
    
    /**
     * This gets the ArrayList of elements found in the floor
     * @return This returns the list of elements found in the floor
     */

    public ArrayList<String> getElementList(){
        return elementList;
    }
    
    /**
     * This gets the ArrayList of characters found in the floor
     * @return This returns the list of characters found in the floor
     */
    
    public ArrayList<Character> getCharacterList(){
        return characterList;
    }
    
    /**
     * This gets the ArrayList of enemies found in the floor
     * @return This returns the list of enemies found in the floor
     */
    
    public ArrayList<Enemy> getEnemyList(){
        return enemyList;
    }
    
    /**
     * This gets the stage level of the floor
     * @return This returns the floor's stage
     */
    
    public String getStage(){
        return stage;
    }
    
    /**
     * This gets the conquered status of a floor, whether it has been conquered by the player or not
     * @return This returns the conquered status of the floor
     */
    
    public boolean getConquered(){
        return conquered;
    }
    
    /**
     * This gets the length of the ArrayList<Floor> floorList
     * @return This returns the integer length of the list of floors
     */
    
    public static int getFloorListLength() {
        return floorList.size();
    }
    
    /**
     * This gets the index of the specified floor in the floor list
     * @param floor the specified floor
     * @return This returns the index of the specified floor
     */
    
    public static int getFloorIndex(Floor floor) throws NullPointerException {
        if(floorList.contains(floor)) return floorList.indexOf(floor);
        else throw new NullPointerException();
    }
    
    /**
     * This loads the floor description of the specified floor from the floorDescription txt file
     * @param floor the specified floor
     * @return This returns the String floor description
     */
    
    public static String loadFloorDescription(Floor floor) {
        InputStream txt = Floor.class.getClassLoader().getResourceAsStream("/assets/text/floorDescriptions.txt");
        InputStreamReader rdr = new InputStreamReader(txt);
        BufferedReader reader = new BufferedReader(rdr);
        
        Scanner scanner = new Scanner(reader);
        boolean tokenFound = true;
        StringBuilder stringBuilder = new StringBuilder();
        
        while(scanner.hasNextLine() && tokenFound == false) {
            String line = scanner.nextLine().trim();
            
            if(line.equals("<-- FLOOR " + floor.getFloorIndex(floor) + ": " + name + " -->")) {
                tokenFound = true;
            } else if(line.equals("<-- FLOOR " + floor.getFloorIndex(floor) + ": " + name + " END -->")) {
                tokenFound = false;
            }
            
            if ((tokenFound) && (!line.equals("<-- FLOOR " + floor.getFloorIndex(floor) + ": " + name + " -->"))) {
                stringBuilder.append(line);
            } 
        }
        
        String finalString = stringBuilder.toString();
        return finalString;
    }
    
    
}
