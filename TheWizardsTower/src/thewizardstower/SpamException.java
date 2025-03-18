/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package skeletoncodeforaa;

/**
 *
 * @author Vaio
 */
public class SpamException extends Exception{

    /**
     * Creates a new instance of <code>SpamException</code> without detail
     * message.
     */
    public SpamException() {
    }

    /**
     * Constructs an instance of <code>SpamException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SpamException(String msg) {
        super(msg);
    }
}
