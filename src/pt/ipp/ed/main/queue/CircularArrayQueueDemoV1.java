/*
 * 
 * Array Circular com tamanho fixo
 * https://www.programiz.com/dsa/circular-queue
 * 
 */
package pt.ipp.ed.main.queue;

import pt.ipp.ed.collections.queue.CircularArrayQueueV1;

/**
 *
 * @author Utilizador
 */
public class CircularArrayQueueDemoV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CircularArrayQueueV1<Integer> q = new CircularArrayQueueV1<>();
        q.display();
        q.enqueue(1);
        q.display();
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        // Fails to enqueue because front == 0 && rear == SIZE - 1
        q.enqueue(6);
        
        q.display();

        int elem = q.dequeue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();
        elem = q.dequeue();

        if (elem != -1) {
            System.out.println("Deleted Element is " + elem);
        }
        q.display();
        q.enqueue(7);
        q.display();
        q.enqueue(8);
        q.display();

        // Fails to enqueue because front == rear + 1
        q.enqueue(9);
        q.display();

    }
}
