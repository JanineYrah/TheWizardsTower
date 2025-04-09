/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thewizardstower;
import java.util.ArrayList;
/**
 * This class represents the Character class.
 * @author Vaio
 */
public class Character {
    
    /**
    * This refers to the character's given name.
    */
    
    protected String name;
    
    /**
    * This refers to the maximum number that their health can reach.
    */
    
    protected int maxhp,
            
            /**
            * This refers to the character's current health.
            */
            
            hp,

            /**
            * This refers to the character's default attack, or the default amount of damage that they can inflict on other characters.
            */
            
            baseAttack,

            /**
            * This refers to the character's default agility, or their default speed.
            */
            
            baseAgility,

            /**
            * This refers to the maximum number of items that the character can actively utilize at a given time.
            */
            
            maxEquipped;
    
    /**
    * This refers to the item that the character is currently using.
    */
    
    protected Item currentItem;
    
    /**
    * This refers to the character's default defense.
    */
    
    protected double baseDefense;
    
    /**
    * This refers to the current floor, or the current level, that the character is in.
    */
    
    protected Floor currentFloor;
    
    /**
    * This refers to the current surrounding that the character is in.
    */
    
    protected Surrounding currentSurrounding;
    
    /**
    * This refers to the stocked inventory of the character.
    */
    
    protected Inventory inventory;
    
    /**
     * This constructor creates a new character object.
     * @param name The specified name to be assigned to the character.
     * @param hp The specified health first assigned to the character.
     * @param attach The specified base attack amount.
     * @param defense The specified base defense amount.
     * @param agility The specified base agility amount.
     * @param maxEquipped The specified maximum number of items the character can equip.
     * @param floor The floor that the character is in.
     * @param inventory The specified inventory.
     * @return This constructs a new character that is placed into a specific floor.
     */
    
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
    
    /**
     * This method gets the character's current hp.
     * @return Returns the player's health (hp) value.
     */
    
    public int getHp(){
        return hp;
    }
    
    /**
     * This method sets the character's hp to a specified amount.
     * @param hp The specified hp.
     * @return Returns the new set hp for the character.
     */
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    /**
     * This method gets the character's default defense.
     * @return Returns the character's baseDefense value.
     */
    
    public double getDefense(){
        return baseDefense;
    }
    
    /**
     * This method sets the character's base defense to a specified amount.
     * @param defense The specified defense.
     * @return Returns the new set base defense for the character.
     */
    
    public void setDefense(int defense){
        baseDefense = defense;
    }
    
    /**
     * This method gets the character's default agility.
     * @return Returns the character's baseAgility value.
     */
    
    public int getAgility(){
        return baseAgility;
    }
    
    /**
     * This method sets the character's base agility to a specified amount.
     * @param agility The specified agility.
     * @return Returns the new set base agility for the character.
     */
    
    public void setAgility(int agility){
        baseAgility = agility;
    }
    
    /**
     * This method gets the number of maximum items the character can actively utilize.
     * @return Returns the character's maxEquipped value.
     */
    
    public int getMaxEquipped(){
        return maxEquipped;
    }
    
    /**
     * This method gets the character's default attack.
     * @return Returns the character's baseAttack value.
     */
    
    public int getAtk(){
        return baseAttack;
    }
    
    /**
     * This method gets the character's inventory.
     * @return Returns the character's inventory.
     */
    
    public Inventory getInventory(){
        return inventory;
    }
    
    /**
     * This method gets the current floor that the character is in.
     * @return Returns the character's currentFloor value.
     */
    
    public Floor getFloor(){
        return currentFloor;
    }
    
    /**
     * This method decreases the health of a different character that the assaulting character attacks.
     * @param character The specified character being attacked.
     * @return Returns a decreased health of the character that was attacked depending on their defense and the baseAttack of the assaulting character.
     */
    
    public void attack(Character character){
        int health = character.getHp();
        health -= (character.getDefense()*baseAttack);
        character.setHp(health);
    }
    
    /**
     * This method allows the specified character to not be able to take any damage from direct attacks.
     * @param character The specified character.
     * @return Returns a statement saying that the specified character defended themselves and will not take any damage.
     */
    
    public void defend(Character c){
        System.out.println(name + " defended theirself! They won't take any damage");
    }
    
    /**
     * This method detects the current placement of the character in the game.
     * @param array The surrounding map represented in a 2D array.
     * @param target The intended target.
     * @return Returns the row and column of where the target is if it is found, and a value of [-1, -1] if it is not found.
     */
    
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
    
    /**
     * This method moves the character in a specified direction for a specified distance in the surrounding in the game.
     * @param arr A placement in the surrounding represented with a 2D array.
     * @param row The current row that the character is in.
     * @param col The current column that the character is in.
     * @param direction The specified direction of movement.
     * @return Returns movement of the character in the specified direction throughout the affected row or column.
     */
    
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
    
    /**
     * This method allows the character to move in the specified direction faster or slower depending on their agility.
     * @param direction The specified direction of movement.
     * @return Returns movement of the character in the specified direction throughout the affected row or column.
     */
    
    public void sprint(String direction){
       
    }
    
    /**
     * This method temporarily allows the character to more quickly move in the specified direction for a temporary amount of time and distance.
     * @param direction The specified direction of movement.
     * @return Returns movement of the character in the specified direction throughout the affected row or column.
     */
    
    public void dash(String direction){
       
        
    }
    
    /**
     * This method temporarily allow the character to more quickly move in the specified direction for a temporary amount of time and distance.
     * @param direction The specified direction of movement.
     * @return Returns movement of the character in the specified direction throughout the affected row or column.
     */
    
    public void roll(String direction){
        
        
    }
    
    /**
     * This method allow the character to gain height by jumping.
     * @return Returns a temporary animation of sprites and a gain in height, signalling that the character has jumped.
     */
    
    public void jump(){
        
        
    }
    
    /**
     * This method allow the character to gain double the height by pressing the jump key twice.
     * @return Returns a temporary animation of sprites and a gain in height, signaling that the character has jumped.
     */
    
    public void doubleJump(){
        
        
    }
    
    /**
     * This method adds the specified item that the character decides to pick up into their inventory.
     * @param item The specified item.
     * @return Places the specified item into the character's inventory.
     * @throws ItemNotFoundException When the item that the character is trying to add into their inventory does not exist.
     * @throws InventoryFullException When the character's inventory has no more free slots and has reached its maximum capacity.
     */
    
    public void pickupItem(Item item) throws ItemNotFoundException, InventoryFullException {
        ArrayList<Item> storage = inventory.getInventoryList();
        if (storage.size() < maxEquipped){
            storage.add(item);
            System.out.println(name + " found an item and store it in their invetory!");
        } else if(storage.size() > maxEquipped){
            throw new InventoryFullException(name +"'s invetory is full! They can't equip any more items");
        } else{
            throw new ItemNotFoundException("The item can't be found in the surrounding");
        }
    }
    
    /**
     * This method allows the character to consume or use the specified item.
     * @param item The specified item.
     * @return The specified item is consumed or used by the character.
     * @throws ItemNotFoundException When the item that the character is trying to or use does not exist.
     * @throws InventoryEmptyException When the character's inventory is empty or that the item cannot be found in it.
     */
    
    public void useItem(Item item) throws ItemNotFoundException, InventoryEmptyException{
        ArrayList<Item> storage = inventory.getInventoryList();
        if (storage.contains(item)){
            storage.remove(item);
            System.out.println(name + " used " + item);
        } else if(storage.size()<1){
            throw new InventoryEmptyException(name + "'s invetory is empty! They can't use any item.");
        } else{
            throw new ItemNotFoundException("The item can't be found in " + name + "'s inventory.");
        }
    }
    
    /**
     * This method allows the character to drop specified item, removing it from their inventory.
     * @param item The specified item.
     * @return The specified item is dropped by the character.
     * @throws ItemNotFoundException When the item that the character is trying to drop from their inventory does not exist.
     * @throws InventoryEmptyException When the character's inventory is empty, signaling that there is nothing to drop.
     */
    
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
    
    /**
     * This method switches the character's current floor to a new specified floor.
     * @param floor The specified floor.
     * @return Returns a new floor that the character has been placed into.
     */
    
    public void enterFloor(Floor floor){
        currentFloor = floor;
    }
}