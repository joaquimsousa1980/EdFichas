/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.queue;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class CircularArrayQueueV1<T> {

    int SIZE = 5; // Size of Circular Queue
    public int front, rear;
    int items[] = new int[SIZE];

    public CircularArrayQueueV1() {
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else {
            return false;
        }
    }

    // Adding an element
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % items.length;
            items[rear] = element;
            System.out.println("Inserted " + element);
        }
    }

    // Removing an element
    public int dequeue() {
        int element;
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        } else {
            element = items[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } /* Q has only one element, so we reset the queue after deleting it. */ else {
                front = (front + 1) % SIZE;
            }
            return (element);
        }
    }

    public void display() {
        /* Function to display status of Circular Queue */
        int i;
        if (isEmpty()) {
            //entra se front = -1
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.print("Items -> ");
            for (i = front; i != rear; i = (i+1)%SIZE) {
                System.out.print(items[i] + " ");
            }
            System.out.println(items[i]);
            System.out.println("Rear -> " + rear);
        }
    }

}
