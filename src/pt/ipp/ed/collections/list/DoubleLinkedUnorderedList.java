/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.list;

import pt.ipp.ed.collections.exceptions.ElementNotFoundException;
import pt.ipp.ed.collections.interfaces.UnorderedListADT;

/**
 *
 * @author Utilizador
 */
public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T>
{

	/**
	 * Adds a new element at the beginning of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToFront(T element)
	{
		DoubleNode<T> newNode = new DoubleNode<T>(element);

		// Adds the new node
		newNode.setNext(this.front.getNext());
		newNode.setPrev(this.front);
		this.front.getNext().setPrev(newNode);
		this.front.setNext(newNode);

		// Increments the count
		this.count++;
	}

	/**
	 * Adds a new element at the end of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToRear(T element)
	{
		DoubleNode<T> newNode = new DoubleNode<T>(element);

		// Adds the new Node
		newNode.setNext(this.rear);
		newNode.setPrev(this.rear.getPrev());
		this.rear.getPrev().setNext(newNode);
		this.rear.setPrev(newNode);

		// Increments the count
		this.count++;
	}

	/**
	 * Adds a new element after another already inserted in the list.
	 *
	 * @param element The element to be added to this list
	 * @param target Target element
	 */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException
	{
		DoubleNode<T> newNode = new DoubleNode<T>(element);
		DoubleNode<T> cur = this.front.getNext();

		// Creates a temporary compator
		Comparable<T> comp = (Comparable<T>) target;

		// Search for target
		while (cur.getNext() != null && !comp.equals(cur.getValue())) {
			cur = cur.getNext();
		}

		// If the target is not found
		if (!cur.getValue().equals(target)) {
			throw new ElementNotFoundException("Not found");
		}

		// Adds the new Node
		newNode.setNext(cur.getNext());
		newNode.setPrev(cur);
		cur.getNext().setPrev(newNode);
		cur.setNext(newNode);

		// Increments the count
		this.count++;
	}
}