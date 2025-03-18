/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package thewizardstower;

/**
 *
 * @author Vaio
 */
public class OccupiedGenerationException extends Exception{

    /**
     * Creates a new instance of <code>OccupiedGenerationException</code> without
     * detail message.
     */
    public OccupiedGenerationException() {
    }

    /**
     * Constructs an instance of <code>OccupiedGenerationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public OccupiedGenerationException(String msg) {
        super(msg);
    }
}
