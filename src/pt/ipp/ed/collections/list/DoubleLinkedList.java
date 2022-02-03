/*
 * DoubleLinkedList.java       
 *                   
 * Represents an doubly linked implementation of a list.
 * The front of the list is kept by front. The rear by rear.
 * This class will be extended to create a specific kind of list.
 */
package pt.ipp.ed.collections.list;

import java.util.Iterator;
import pt.ipp.ed.collections.exceptions.*;


/**
 *
 * @author 8100423 Joaquim Sousa
 * @param <T>
 */
public class DoubleLinkedList<T>  extends AbstractList<T> {

    protected DoubleNode<T> front, rear;
    protected int count;

    // Creates an empty list using the default capacity.
    public DoubleLinkedList() {
        rear = null;
        front = null;
        count = 0;
    }

    // Removes and returns the first element in the list.
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        T result = front.getValue();
        front = front.getNext();

        if (front == null) {
            rear = null;
        } else {
            front.setPrev(null);
        }
        count--;

        return result;
    }

    // Removes and returns the last element in the list.
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        T result = rear.getValue();
        rear = rear.getPrev();

        if (rear == null) {
            front = null;
        } else {
            rear.setNext(null);
        }
        count--;

        return result;
    }

    // Removes and returns the specified element.
    @Override
    public T remove(T element) {
        T result;
        DoubleNode<T> nodeptr = find(element);

        if (nodeptr == null) {
            throw new ElementNotFoundException("list");
        }

        result = nodeptr.getValue();

        // check to see if front or rear
        if (nodeptr == front) {
            result = this.removeFirst();
        } else if (nodeptr == rear) {
            result = this.removeLast();
        } else {
            nodeptr.getNext().setPrev(nodeptr.getPrev());
            nodeptr.getPrev().setNext(nodeptr.getNext());
            count--;
        }
        return result;
    }

    // Returns a reference to the element at the front of the list.
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return front.getValue();
    }

    // Returns a reference to the element at the rear of the list.
    @Override
    public T last() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        return rear.getValue();
    }

    // Returns true if this list contains the specified element.
    @Override
    public boolean contains(T target) {
        return (find(target) != null);
    }

    // Returns a reference to the specified element, or null if it is not found.
    private DoubleNode<T> find(T target) {
        boolean found = false;
        DoubleNode<T> traverse = front;
        DoubleNode<T> result = null;

        if (!isEmpty()) {
            while (!found && traverse != null) {
                if (target.equals(traverse.getValue())) {
                    found = true;
                } else {
                    traverse = traverse.getNext();
                }
            }
        }

        if (found) {
            result = traverse;
        }
        return result;
    }

    // Returns true if this list is empty and false otherwise. 
    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    // Returns the number of elements currently in this list.
    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        super.clear();
        this.front = new DoubleNode<T>();
        this.rear = new DoubleNode<T>();

        this.front.setNext(this.rear);
        this.rear.setPrev(this.front);
    }

    // Returns an iterator for the elements currently in this list.
    @Override
    public Iterator<T> iterator() {
        return new DoubleIterator<>(front, count);
    }

    //  Returns a string representation of this list. 
    @Override
    public String toString() {
        String result = "";
        DoubleNode<T> traverse = front;

        while (traverse != null) {
            result = result + (traverse.getValue()).toString() + "\n";
            traverse = traverse.getNext();
        }
        return result;
    }

}
