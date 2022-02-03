/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.list;

/**
 *
 * @author Utilizador
 */
public class LinkedList<T> {

    private LinearNode<T> first;
    private LinearNode<T> last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public LinearNode<T> getFirst() {
        return this.first;
    }

    public void setPrimeiro(LinearNode<T> first) {
        this.first = first;
    }

    public LinearNode<T> getLast() {
        return this.last;
    }

    public void setLast(LinearNode<T> last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void addFirst(T element) {
        LinearNode<T> node = new LinearNode<>(element);
        if (isEmpty()) {
            this.last = node;
        } else {
            node.setNext(this.first);
        }
        this.first = node;
        this.size++;
    }

    public void addFirstV0(T element) {
        LinearNode<T> node = new LinearNode<>();//criamos 1 nó, alocamos na memoria
        node.setElement(element);               // node.setElement vai receber a info que veio de parametro         
        node.setNext(this.first);               // proximo vai ser null porque o inicio é null
        this.first = node;                        // lincamos o first ao nó
        this.size++;
    }

    public int countElements() {
        int tamanho = 0;
        LinearNode noTemp = first;
        while (noTemp != null) {
            tamanho = tamanho + 1;
            noTemp = noTemp.getNext();
        }
        return tamanho;
    }

    public void addMiddle(T newValue, int posicao) {
        LinearNode noTemp = first;
        int nroElements, posAux = 1;
        nroElements = countElements();
        if (posicao <= 1) {
            addFirst(newValue);
        } else {
            if (posicao > nroElements) {
                addLast(newValue);
            } else {
                LinearNode<T> newElement = new LinearNode<>(newValue);
                while (posAux < (posicao - 1)) {
                    noTemp = noTemp.getNext();//noTemp.getProx
                    posAux = posAux + 1;
                }
                newElement.setNext(noTemp.getNext());//novoNo.setProx(noTemp.getProx);
                noTemp.setNext(newElement);// noTemp.setProx(novoNo);
            }
        }
    }

    public void addLast(T novoValor) {
        LinearNode<T> newElement = new LinearNode<>(novoValor);
        if (isEmpty()) {
            this.first = newElement;
        } else {
            //o ultimo vai ter um proximo que é o novoElemento
            this.last.setNext(newElement);
        }
        this.last = newElement;
        this.size++;
    }

    public int contarElementos() {
        int tamanho = 0;
        LinearNode elementoTemp = first;
        while (elementoTemp != null) {
            tamanho = tamanho + 1;
            elementoTemp = elementoTemp.getNext();
        }
        return tamanho;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void showList() {
        int i = 1;
        LinearNode noTemp = first;
        while (noTemp != null) {
            System.out.println("Elemento " + noTemp.getElement() + " posição " + i);
            noTemp = noTemp.getNext();
            i++;
        }
    }

    public T removeFirst() {
        if (this.first == null) {
            return null;
        }
        // guardamos o inicio
        T info = first.getElement(); //salvamos a informacao para utilizar depois
        //apontar o unicio para o proximo dele
        this.first = this.first.getNext();
        size--;
        return info;
    }

    public LinearNode<T> remove(T valueSearched) {
        LinearNode provious = null;
        LinearNode current = this.first;
        for (int i = 0; i < this.getSize(); i++) {
            if (current.getElement().equals(valueSearched)) {
                if (this.size == 1) {
                    this.first = null;
                    this.last = null;
                } else if (current == first) {
                    this.first = current.getNext();//atual.getProximo() é o proximo nó
                    current.setNext(null);
                } else if (current == last) {
                    this.last = provious;
                    provious.setNext(null);
                } else {
                    provious.setNext(current.getNext());
                    current = null;
                }
                this.size--;
                break;
            }
            provious = current;
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String toString() {
        String str = "(" + size + ") ";
        LinearNode<T> local = first;
        while (local != null) {
            str += local.getElement() + " ";
            local = local.getNext();
        }
        return str;
    }

}
