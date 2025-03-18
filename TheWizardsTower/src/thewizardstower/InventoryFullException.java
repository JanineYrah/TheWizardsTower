/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package q3aa3_tau_alcayde.tolentino.files;

/**
 *
 * @author Vaio
 */
public class InventoryFullException extends Exception {

    /**
     * Creates a new instance of <code>InventoryFullException</code> without
     * detail message.
     */
    public InventoryFullException() {
    }

    /**
     * Constructs an instance of <code>InventoryFullException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public InventoryFullException(String msg) {
        super(msg);
    }
}
