/**
 * ArrayOrderedList.java
 *
 * Represents an array implementation of an ordered list.
 */
package pt.ipp.ed.collections.list;

import pt.ipp.ed.collections.interfaces.OrderedListADT;

/**
 *
 * @author 8100423 Joaquim Sousa
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {

    // Creates an empty list using the default capacity
    public ArrayOrderedList() {
        super();
    }

    // Creates an empty list using the specified capacity
    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }

    // Adds the specified Comparable element to the list, keeping the elements in sorted order
    @Override
    public void add(T element) {
        // Checks if the size is sufficient, if not, the array expands
        if (this.rear == list.length) {
            expandCapacity();
        }

        // Creates a temporary compator
        Comparable<T> temp = (Comparable<T>) element;

        // Scrolls the list to the position where the element will be inserted
        int scan = 0;
        while (scan < this.rear && temp.compareTo(this.list[scan]) > 0) {
            scan++;
        }

        // Drag all elements above the position of the new element to the side (+1)
        for (int index = this.rear; index > scan; index--) {
            this.list[index] = this.list[index - 1];
        }

        // Adds the element
        this.list[scan] = element;

        this.rear++;
    }
}
