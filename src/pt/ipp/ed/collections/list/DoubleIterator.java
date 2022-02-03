/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.list;

import java.util.*;


/**
 *
 * @author Utilizador
 */
public class DoubleIterator<T> implements Iterator
{
   private int count;  // the number of elements in the collection
   private DoubleNode<T> current;  // the current position

   //-----------------------------------------------------------------
   //  Sets up this iterator using the specified items.
   //-----------------------------------------------------------------
   public DoubleIterator (DoubleNode<T> list, int size)
   {
      current = list;
      count = size;
   }

   //-----------------------------------------------------------------
   //  Returns true if this iterator has at least one more element
   //  to deliver in the iteraion.
   //-----------------------------------------------------------------
   public boolean hasNext()
   {
      return (current != null);
   }

   //-----------------------------------------------------------------
   //  Returns the next element in the iteration. If there are no
   //  more elements in this itertion, a NoSuchElementException is
   //  thrown.
   //-----------------------------------------------------------------
   public T next()
   {
      if (! hasNext())
         throw new NoSuchElementException();

      T result = current.getValue();
      current = current.getNext();
      return result;
   }

   //-----------------------------------------------------------------
   //  The remove operation is not supported.
   //-----------------------------------------------------------------
   public void remove() throws UnsupportedOperationException
   {
      throw new UnsupportedOperationException();
   }
}