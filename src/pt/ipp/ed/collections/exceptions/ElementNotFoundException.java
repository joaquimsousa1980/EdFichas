/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.exceptions;

/**
 *
 * @author Utilizador
 */
public class ElementNotFoundException extends RuntimeException {

   //Sets up this exception with an appropriate message.
    public ElementNotFoundException(String message) {
        super("The target element is " + message);
    }
}
