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
public class Character {
    protected String name;
    protected int maxhp,hp, baseAttack, baseAgility, maxEquipped;
    protected Item currentItem;
    protected double baseDefense;
    protected Floor currentFloor;
    protected Surrounding currentSurrounding;
    protected Inventory inventory;
    
    public Character(String name, int hp, int attack, double defense, int agility, int maxEquipped, Floor floor, Inventory inventory){
        this.name = name;
        this.maxhp = hp;
        this.hp = hp;
        this.baseAttack = attack;
        this.baseDefense = defense;
        this.baseAgility = agility;
        this.maxEquipped = maxEquipped;
        this.currentFloor = floor;
        this.inventory = inventory;
    }
    
    public int getHp(){
        return hp;
    }
    
    public void setHp(int a){
        hp = a;
    }
    
    public double getDefense(){
        return baseDefense;
    }
    
    public void setDefense(int a){
        baseDefense = a;
    }
    
    public int getAgility(){
        return baseAgility;
    }
    
    public void setAgility(int a){
        baseAgility = a;
    }
    
    public int getMaxEquipped(){
        return maxEquipped;
    }
    
    public int getAtk(){
        return baseAttack;
    }
    
    public Inventory getInventory(){
        return inventory;
    }
    
    public Floor getFloor(){
        return currentFloor;
    }
    
    public void attack(Character c){
        int health = c.getHp();
        health -= (c.getDefense()*baseAttack);
        c.setHp(health);
    }
    
    public void defend(Character c){
        System.out.println(name + " defended theirself! They won't take any damage");
    }
    
    
    public int[] findValue(int[][] array, int target) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) { // Loop through columns
                if (array[row][col] == target) { // Check if the value matches
                    return new int[] {row, col}; // Return row and column as an array
                }
            }
        }
        return new int[] {-1, -1}; // Return -1, -1 if the value is not found
    }   
    
    public static void move(int[][] arr, int row, int col, String direction) {
        int rows = arr.length;
        int cols = arr[0].length;

        // Determine the new position based on the direction
        int newRow = row, newCol = col;
        switch (direction.toLowerCase()) {
            case "up":
                newRow = row - 1;
                break;
            case "down":
                newRow = row + 1;
                break;
            case "left":
                newCol = col - 1;
                break;
            case "right":
                newCol = col + 1;
                break;
            default:
                System.out.println("Invalid direction. Use 'up', 'down', 'left', or 'right'.");
                return;
        }
    }
    
    public void sprint(String direction){
       
    }
    
    public void dash(String direction){
       
        
    }
    
    public void roll(String direction){
        
        
    }
    
    public void jump(){
        
        
    }
    
    public void doubleJump(){
        
        
    }
    
    public void pickupItem(Item i) throws ItemNotFoundException, InventoryFullException{
        ArrayList<Item> storage = inventory.getInventoryList();
        if (storage.size() < maxEquipped){
            storage.add(i);
            System.out.println(name + " found an item and store it in their invetory!");
        } else if(storage.size() > maxEquipped){
            throw new InventoryFullException(name +"'s invetory is full! They can't equip any more items");
        } else{
            throw new ItemNotFoundException("The item can't be found in the surrounding");
        }
    }
    
    public void useItem(Item i) throws ItemNotFoundException, InventoryEmptyException{
        ArrayList<Item> storage = inventory.getInventoryList();
        if (storage.contains(i)){
            storage.remove(i);
            System.out.println(name + " used " + i);
        } else if(storage.size()<1){
            throw new InventoryEmptyException(name + "'s invetory is empty! They can't use any item.");
        } else{
            throw new ItemNotFoundException("The item can't be found in " + name + "'s inventory.");
        }
    }
    
    public void dropItem(Item i) throws ItemNotFoundException, InventoryEmptyException{
        ArrayList<Item> storage = inventory.getInventoryList();
        if (storage.contains(i)){
            storage.remove(i);
            System.out.println(name + " dropped " + i);
        } else if(storage.size()<1){
            throw new InventoryEmptyException(name + "'s invetory is empty! They can't drop any item.");
        } else{
            throw new ItemNotFoundException("The item can't be found in " + name + "'s inventory.");
        }
    }
    
    public void enterFloor(Floor f){
        currentFloor = f;
    }
}
