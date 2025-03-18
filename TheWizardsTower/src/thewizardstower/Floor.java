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
public class Floor {
    protected ArrayList<String> elementList;
    protected ArrayList<Character> characterList;
    protected ArrayList<Enemy> enemyList;
    protected String stage, name, description;
    protected boolean conquered;
    
    public Floor(String name, String description, ArrayList<String> elementList,
            ArrayList<Character> characterList, ArrayList<Enemy> enemyList, String stage){
        this.name = name;
        this.description = description;
        this.elementList = elementList;
        this.characterList = characterList;
        this.enemyList = enemyList;
        this.stage = stage;
        conquered = false;
    }
    
    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public ArrayList<String> getElementList(){
        return elementList;
    }
    
    public ArrayList<Character> getCharacterList(){
        return characterList;
    }
    
    public ArrayList<Enemy> getEnemyList(){
        return enemyList;
    }
    
    public String getStage(){
        return stage;
    }
    
    public boolean getConquered(){
        return conquered;
    }
    
    
}
