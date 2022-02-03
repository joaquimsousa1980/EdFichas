/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.main.stack;

import java.util.Scanner;
import pt.ipp.ed.collections.stack.ArrayStack;
/**
 *
 * @author Utilizador
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int userInput;
        System.out.println("Enter a inicial capacity");
        userInput = scan.nextInt();
        ArrayStack<Integer> stack1 = new ArrayStack<Integer>(userInput);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(100000);
        stack1.push(1000000);
        stack1.push(9999999);
        stack1.push(313224);
        stack1.push(1);
        stack1.push(2);
        stack1.push(4);
        System.out.println(stack1);
        System.out.println("You popped off " + stack1.pop());
        System.out.println(stack1);
        System.out.println(stack1.peek());
        System.out.println(stack1.isEmpty());
        System.out.println(stack1.size());
        System.out.println(50000);
        System.out.println(stack1.size());
    }

}
