/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.stack;

import pt.ipp.ed.collections.exceptions.EmptyCollectionException;
import pt.ipp.ed.collections.list.LinearNode;
import pt.ipp.ed.collections.interfaces.StackADT;

/**
 *
 * @author Utilizador
 * @param <T>
 */
public class LinkedStack<T> implements StackADT<T> {

    private LinearNode<T> first;
    private LinearNode<T> last;
    private int size;

    public LinkedStack() {
    }

    @Override
    public void push(T element) {
        //cria um novo nó
        LinearNode<T> newNode = new LinearNode<>(element);
        //verifica se a stack esta vazia
        if (isEmpty()) {
            //O novo nó é o ultimo
            this.last = newNode;
        } else {
            newNode.setNext(this.first);// //o novo nó vai ter um proximo que é o primeiro   
        }
        //O novo nó é o primeiro
        this.first = newNode;
        this.size++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }
        LinearNode<T> current = this.first;
        this.first = current.getNext();//front.getProximo() é o proximo nó
        this.size--;
        return current.getElement();

    }

    @Override
    public T peek() {
        return this.first.getElement();
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return this.size;
    }

}
