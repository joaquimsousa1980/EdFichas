/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.list;

import java.util.Iterator;
import pt.ipp.ed.collections.exceptions.ElementNotFoundException;
import pt.ipp.ed.collections.exceptions.EmptyCollectionException;
import pt.ipp.ed.collections.interfaces.ListADT;

/**
 *
 * @author Utilizador
 */
public abstract class AbstractList<T> implements ListADT<T>
{
	protected int count = 0;
	
	/**
	 * Sole constructor.
	 */
	protected AbstractList()
	{
		super();
	}

	@Override
	public T removeFirst() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T removeLast() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T first() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T last() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(T target) throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns true if this list no contains elements.
	 * 
	 * @return true if this list no contains elements
	 */
	@Override
	public boolean isEmpty()
	{
		return (this.size() == 0);
	}

	/**
	 * Returns the number f elements in this list.
	 * 
	 * @return the integer representation of number of elements in this list
	 */
	@Override
	public int size()
	{
		return this.count;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear()
	{
		this.count = 0;
	}

	@Override
	public Iterator<T> iterator()
	{
		throw new UnsupportedOperationException();
	}
}