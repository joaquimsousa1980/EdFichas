/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.list;

import java.util.Iterator;
import pt.ipp.ed.collections.exceptions.*;
import pt.ipp.ed.collections.interfaces.OrderedListADT;

/**
 *
 * @author Utilizador
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T>{
   
    // Creates an empty list using the default capacity.
    public DoubleLinkedOrderedList() {
        super();
    }
    
    //  Adds the specified element after the specified target element.
    //  Throws a ElementNotFoundException if the target is not found.


    @Override
    public void add(T element) {
        Comparable temp;
        if (element instanceof Comparable) {
            temp = (Comparable) element;
        } else {
            throw new NonComparableElementException("double ordered list");
        }

        DoubleNode<T> traverse = front;
        DoubleNode<T> newnode = new DoubleNode<T>(element);
        boolean found = false;

        if (isEmpty()) {
            front = newnode;
            rear = newnode;
        } else if (temp.compareTo(rear.getValue()) >= 0) {
            rear.setNext(newnode);
            newnode.setPrev(rear);
            newnode.setNext(null);
            rear = newnode;
        } else if (temp.compareTo(front.getValue()) <= 0) {
            front.setPrev(newnode);
            newnode.setNext(front);
            newnode.setPrev(null);
            front = newnode;
        } else {
            while ((temp.compareTo(traverse.getValue()) > 0)) {
                traverse = traverse.getNext();
            }

            newnode.setNext(traverse);
            newnode.setPrev(traverse.getPrev());
            traverse.getPrev().setNext(newnode);
            traverse.setPrev(newnode);
        }
        count++;

    }
    public T[] invert(){
        int i = 1;
                T vetor[] = (T[]) new Object[this.size()];
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            vetor[this.size() - i] = it.next();
            i++;
        }
        return vetor;
    }

}
