/*
 * DoubleNode.java
 *
 * Represents a node in a doubly linked list.
 */
package pt.ipp.ed.collections.list;

/**
 *
 * @author 8100423 Joaquim Sousa
 * @param <T>
 */
public class DoubleNode<T> {

    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> prev;

    /**
     * Creates an empty node
     */
    public DoubleNode() {

    }

    /**
     * Creates a node with a value and that the next and previous points to null
     *
     * @param value Value to be saved
     */
    public DoubleNode(T value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    /**
     * Gets the value stored by the node
     *
     * @return the value
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets a value to be stored by the node
     *
     * @param value the value to set
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Gets a reference to the next node
     *
     * @return the next
     */
    public DoubleNode<T> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node
     *
     * @param next the next to set
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    /**
     * Gets a reference to the previous node
     *
     * @return the prev
     */
    public DoubleNode<T> getPrev() {
        return prev;
    }

    /**
     * Sets the reference to the previous node
     *
     * @param prev the prev to set
     */
    public void setPrev(DoubleNode<T> prev) {
        this.prev = prev;
    }

}
