/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.stack;

import pt.ipp.ed.collections.list.LinkedList;
import pt.ipp.ed.collections.interfaces.StackADT;

/**
 *
 * @author Utilizador
 */
public class LinkedStackV0<T> implements StackADT<T> {

    private LinkedList<T> list;

    public LinkedStackV0() {
        this.list = new LinkedList<>();
    }

    
    public void push(T newValue) {
        this.list.addFirst(newValue);
    }

   
    public T pop() {
        this.list.remove(this.peek());
        return peek();
    }

 
    public T peek() {
        return list.getFirst().getElement();
    }

    @Override
    //retorna verdadeiro se estiver vazia
    public boolean isEmpty() {
             //lstack.getFirst().getValue());
        return list.getFirst() == null;
    }

    @Override
    public int size() {
       return list.getSize();
    }


}
