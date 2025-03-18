/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package thewizardstower;

/**
 *
 * @author Vaio
 */
public class ComboException extends Exception {

    /**
     * Creates a new instance of <code>ComboException</code> without detail
     * message.
     */
    public ComboException() {
    }

    /**
     * Constructs an instance of <code>ComboException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ComboException(String msg) {
        super(msg);
    }
}
