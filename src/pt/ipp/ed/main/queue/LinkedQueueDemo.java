/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.main.queue;

import pt.ipp.ed.collections.interfaces.QueueADT;
import pt.ipp.ed.collections.queue.LinkedQueue;

/**
 *
 * @author Utilizador
 */
public class LinkedQueueDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QueueADT<String> queue = new LinkedQueue<>();
        System.out.println("A stack esta vazia?: " + queue.isEmpty());
        System.out.println("Numero de elementos: " + queue.size());
        queue.enqueue("João");
        queue.enqueue("Zé");
        queue.enqueue("Juca");
        queue.enqueue("Maria");
        queue.enqueue("Ana");
        System.out.println("---"+queue.toString());
        System.out.println("Primeiro da fila: " + queue.first());
        queue.dequeue();
        System.out.println("Novo primeiro: " + queue.first());
        queue.dequeue();
        System.out.println("Novo primeiro: " + queue.first());
        queue.dequeue();
        System.out.println("Novo primeiro: " + queue.first());
        System.out.println("A stack esta vazia?: " + queue.isEmpty());
        System.out.println("Numero de elementos: " + queue.size());
    }

}
