/**
 * CircularArrayQueue represents an array implementation of a queue in
 * which the indexes for the front and rear of the queue circle back to 0
 * when they reach the end of the array.
 *
 * @author Joaquim Sousa
 * @version 1.0 08/12/2021
 */
package pt.ipp.ed.collections.queue;

import pt.ipp.ed.collections.exceptions.EmptyCollectionException;
import pt.ipp.ed.collections.interfaces.QueueADT;

public class CircularArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_CAPACITY = 5;
    public int front, rear, count;
    public T[] queue;

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        front = rear = count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty queue using the specified capacity.
     *
     * @param initialCapacity the integer representation of the initial size of
     * the circular array queue
     */
    public CircularArrayQueue(int initialCapacity) {
        front = rear = count = 0;
        queue = ((T[]) (new Object[initialCapacity]));
    }

    /**
     * Adds the specified element to the rear of this queue, expanding the
     * capacity of the queue array if necessary.
     *
     * @param element the element to add to the rear of the queue
     */
    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }

        queue[rear] = element;
        rear = (rear + 1) % queue.length;

        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to
     * it. Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the reference to the element at the front of the queue that was
     * removed
     * @throws EmptyCollectionException if an empty collections exception occurs
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;

        return result;
    }

    /**
     * Returns a reference to the element at the front of the queue. The element
     * is not removed from the queue. Throws an EmptyCollectionException if the
     * queue is empty.
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return queue[front];
    }

    /**
     * Returns true if this queue is empty and false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns the number of elements currently in this queue.
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this queue.
     */
    @Override
    public String toString() {
        String result = "";
        int scan = 0;

        while (scan < count) {
            if (queue[scan] != null) {
                result += queue[scan].toString() + "\n";
            }
            scan++;
        }

        return result;

    }

    public String toString1() {
        StringBuffer sb = new StringBuffer("CircularArrayQueue [");
        int next = front;
        for (int i = 0; i < count; i++) {
            sb.append(queue[next]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Creates a new array to store the contents of this queue with twice the
     * capacity of the old one.
     */
    public void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);

        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
        }

        front = 0;
        rear = count;
        queue = larger;
    }

    public void display() {
        /* Function to display status of Circular Queue */

        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            System.out.println("Front -> " + front);
            System.out.print("Elements in Circular Queue are: ");
            for (i = front; i != rear; i = (i + 1) % queue.length) {
                System.out.print(queue[i] + " ");
            }
            System.out.println("\nRear  -> " + rear);
        }
    }
}
