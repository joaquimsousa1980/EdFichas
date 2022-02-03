/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.main.queue;

import pt.ipp.ed.collections.queue.CircularArrayQueue;

/**
 *
 * @author Utilizador
 */
public class CircularArrayQueueDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularArrayQueue<String> qalfabeto = new CircularArrayQueue<>();
        CircularArrayQueue<String> q = new CircularArrayQueue<>();
        q.display();
        q.enqueue("A");
        q.display();
        q.enqueue("B");
        q.enqueue("C");
        q.enqueue("D");
        q.display();
      //  System.out.println(q.toString1());verificar
        System.out.println("Deleted Element is " + q.dequeue());
        q.display();
        System.out.println("Deleted Element is " + q.dequeue());
        q.display();
        q.enqueue("E");
        q.display();
        q.enqueue("F");
        q.display();
        q.enqueue("G");
        q.display();
    }
}
