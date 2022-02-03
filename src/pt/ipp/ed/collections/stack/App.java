/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.stack;

import pt.ipp.ed.collections.interfaces.SmackStackADT;

/**
 *
 * @author Utilizador
 */
public class App {

    public static void fp6ex1() {
        SmackStackADT<Integer> smack = new ArrayStack<>();
        smack.push(10);
        smack.push(8);
        smack.push(4);
        smack.push(33);
        System.out.println("Tamanho: " + smack.size());

        System.out.println(smack.Smack());
        System.out.println("Tamanho: " + smack.size());
    }

    public static void main(String[] args) {
        fp6ex1();
    }

}
