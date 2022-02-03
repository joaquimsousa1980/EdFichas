/**
 * LinkedQueue represents a linked implementation of a queue.
 *
 * @author Joaquim Sousa
 * @version 1.0, 08/12/2021
 */
package pt.ipp.ed.collections.queue;

import pt.ipp.ed.collections.exceptions.EmptyCollectionException;
import pt.ipp.ed.collections.interfaces.QueueADT;
import pt.ipp.ed.collections.list.LinearNode;

public class LinkedQueue<T> implements QueueADT<T> {

    private LinearNode<T> front;
    private LinearNode<T> rear;
    private int count;

    /**
     * Creates an empty queue.
     */
    public LinkedQueue() {
        count = 0;
        front = rear = null;
    }

    public LinearNode<T> getFront() {
        return front;
    }

    public void setFront(LinearNode<T> front) {
        this.front = front;
    }

    public LinearNode<T> getRear() {
        return rear;
    }

    public void setRear(LinearNode<T> rear) {
        this.rear = rear;
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(element);
        if (isEmpty()) {
            this.front = node;
        } else {
            this.rear.setNext(node);// o near vai passar a ter no next a referencia do novo no;
        }
        rear = node;
        count++;
    }

    /**
     * Removes the element at the front of this queue and returns a reference to
     * it. Throws an EmptyCollectionException if the queue is empty.
     *
     * @return the element at the front of this queue
     * @throws EmptyCollectionException if an empty collection exception occurs
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        T removed = this.front.getElement();//guardamos o elemento que vamos remover
        this.front = this.front.getNext();  // alteramos o apontador para o proximo
        count--;
        return removed;//retornamos o elemento removido
    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    /**
     * Returns without removing the element at the front of this queue. The
     * element is not removed from the queue. Throws an EmptyCollectionException
     * if the queue is empty.
     *
     * @return the first element in this queue
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return front.getElement();
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString() {
        String result = "";
        LinearNode<T> current = front;

        while (current != null) {
            result = result + (current.getElement()).toString() + "\n";
            current = current.getNext();
        }

        return result;
    }
}
