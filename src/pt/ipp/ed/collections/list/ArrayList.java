package pt.ipp.ed.collections.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import pt.ipp.ed.collections.exceptions.ElementNotFoundException;
import pt.ipp.ed.collections.exceptions.EmptyCollectionException;
import pt.ipp.ed.collections.interfaces.ListADT;

public abstract class ArrayList<T> implements ListADT<T> {

    // Variaveis de instância
    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;
    protected int modCount; //modification counter 

    // Creates an empty list using the default capacity.
    public ArrayList() {
        this.rear = 0;
        this.list = (T[]) (new Object[DEFAULT_CAPACITY]);
        this.modCount = 0;
    }

    // Creates an empty list using the specified capacity
    public ArrayList(int initialCapacity) {
        this.rear = 0;
        this.list = (T[]) (new Object[initialCapacity]);
        this.modCount = 0;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws EmptyCollectionException Indicates that the list is empty
     */
    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        T delete = this.list[0];
        this.rear--;

        // Shift the elements
        for (int scan = 0; scan < this.rear; scan++) {
            this.list[scan] = this.list[scan + 1];
        }
        this.list[this.rear] = null;
        this.modCount++;
        return delete;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws EmptyCollectionException Indicates that the list is empty
     */
    @Override
    public T removeLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        this.rear--;
        T delete = this.list[this.rear];
        this.list[this.rear] = null;
        this.modCount++;
        return delete;
    }

    /**
     * Removes and returns the specified element from this list.
     *
     * @param element the element to be removed from the list
     * @return the specified element from this list
     *
     * @throws EmptyCollectionException Indicates that the list is empty
     * @throws ElementNotFoundException Indicates that the element to be removed
     * is not a part of the list
     */
    @Override
    public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
        // Check if the list is empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        int scan = find(element);
        if (scan == NOT_FOUND) {
            throw new ElementNotFoundException("not Found");
        }

        // Saves the element to be removed
        T delete = this.list[scan];

        /// Shift the elements that are after the removed element
        for (int index = scan; index < this.rear; index++) {
            this.list[index] = this.list[index + 1];
        }

        // Decreasses the rear and the count
        this.rear--;
        this.modCount++;

        // Sets the last position to null
        this.list[this.rear] = null;

        // Returns the element removed
        return delete;
    }

    /**
     * Returns a reference to the first element in this list.
     *
     * @return a reference to the first element in this list
     * @throws EmptyCollectionException Indicates that the list is empty
     */
    @Override
    public T first() throws EmptyCollectionException {
        // Check if the list is empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        // Returns the frist element of the list
        return this.list[0];
    }

    /**
     * Returns a reference to the last element in this list.
     *
     * @return a reference to the last element in this list
     * @throws EmptyCollectionException Indicates that the list is empty
     */
    @Override
    public T last() throws EmptyCollectionException {
        // Check if the list is empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("list");
        }

        // Returns the last element of the list
        return this.list[this.rear - 1];
    }

    /**
     * Returns true if this list contains the specified target element.
     *
     * @param target the target that is being sought in the list
     * @return true if the list contains this element
     * @throws EmptyCollectionException Indicates that the list is empty
     */
    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        // Check if the list is empty
        if (this.isEmpty()) {
            throw new EmptyCollectionException("list");
        }
        for (int index = 0; index < this.rear; index++) {
            if (this.list[index].equals(target)) {
                return true;
            }
        }
        return false;
    }

    // Returns true if this list is empty and false otherwise.
    @Override
    public boolean isEmpty() {
        return (this.rear == 0);
    }

    // Returns the number of elements currently in this list.
    @Override
    public int size() {
        return this.rear;
    }

    // Removes all of the elements from this list.
    @Override
    public void clear() {
        this.modCount = 0;
        this.rear = 0;
        this.list = (T[]) (new Object[this.DEFAULT_CAPACITY]);
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator<>();
    }

    public class BasicIterator<T> implements Iterator<T> {

        private final int size;
        private final T[] items;
        private int current;
        private int expectedModCount;

        public BasicIterator() {
            this.items = (T[]) ArrayList.this.list;
            this.size = ArrayList.this.rear;
            this.current = 0;
            this.expectedModCount = ArrayList.this.modCount;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("ConcorrÃªncia");
            }
            return (this.items[this.current] != null);
        }

        @Override
        public T next() {
            T temp = items[this.current];
            if (hasNext()) {
                this.current++;
            }
            return temp;
        }
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        String result = "";

        for (int scan = 0; scan < this.rear; scan++) {
            result = result + this.list[scan].toString() + "\n";
        }

        return result;
    }

    // Expands the ability of the list to double the current size.
    protected void expandCapacity() {
        // Creates a new list, with double the current positions
        T[] newList = (T[]) (new Object[this.list.length * 2]);

        for (int scan = 0; scan < this.list.length; scan++) {
            newList[scan] = this.list[scan];
        }
        this.list = newList;
    }

    //  Returns the array index of the specified element, or the
    //  constant NOT_FOUND if it is not found
    private int find(T target) {
        int scan = 0;
        int result = this.NOT_FOUND;
        boolean found = false;

        if (!isEmpty()) {
            while (!found && scan < rear) {
                if (target.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }
        if (found) {
            result = scan;
        }
        return result;
    }

}
