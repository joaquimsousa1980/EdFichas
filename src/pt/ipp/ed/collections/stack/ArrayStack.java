package pt.ipp.ed.collections.stack;

import pt.ipp.ed.collections.exceptions.EmptyCollectionException;
import java.util.Arrays;
import pt.ipp.ed.collections.interfaces.SmackStackADT;
import pt.ipp.ed.collections.interfaces.StackADT;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class ArrayStack<T> implements StackADT<T>,SmackStackADT<T> {

    /**
     * constant to represent the default capacity of the array
     */
    private final int DEFAULT_CAPACITY = 100;

    /**
     * int that represents both the number of elements and the next available
     * position in the array
     */
    private int top;

    /**
     * array of generic elements to represent the stack
     */
    private T[] stack;

    /**
     * Creates an empty stack using the default capacity.
     */
    public ArrayStack() {
        top = 0;
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty stack using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     */
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of this stack, expanding the
     * capacity of the stack array if necessary.
     *
     * @param element generic element to be pushed onto stack
     */
    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    @Override
    public int size() {
        return this.top;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element removed from top of stack
     * @throws EmptyCollectionException if a pop is attempted on empty stack
     */
    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        top--; //go back an index so we dont return 0 or null
        T result = stack[top]; //stack holds object refs of type T, (stack[last index](what element its holding)) = T result
        stack[top] = null;// current index is popped and set to null or 0
        return result; // returns result or (object) popped
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack. Throws an EmptyCollectionException if the
     * stack is empty.
     *
     * @return T element on top of stack
     * @throws EmptyCollectionException if a peek is attempted on empty stack
     */
    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        return stack[top - 1];
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    public void info() {
        System.out.println("=== Info ===");
        System.out.println("top " + peek());
        System.out.println("size " + size());
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

    @Override
    public T Smack() 
    {
        pop();
        return peek();
    }
}
