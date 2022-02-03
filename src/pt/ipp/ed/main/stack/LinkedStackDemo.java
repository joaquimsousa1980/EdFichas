/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.main.stack;

import pt.ipp.ed.collections.stack.LinkedStack;
import pt.ipp.ed.collections.interfaces.StackADT;

//import java.util.LinkedStack;

/**
 *
 * @author Utilizador
 */
public class LinkedStackDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();

        System.out.println("A stack esta vazia?: " + stack.isEmpty());
        System.out.println("Numero de elementos: " + stack.size());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");

        System.out.println("Topo: " + stack.peek());
        System.out.println("Removeu: " + stack.pop());
        System.out.println("Novo Topo: " + stack.peek());
        stack.push("Z");
        System.out.println("Removeu: " + stack.pop());
        System.out.println("Novo Topo: " + stack.peek());
        System.out.println("A stack esta vazia?: " + stack.isEmpty());
        System.out.println("Numero de elementos: " + stack.size());
    }
}
