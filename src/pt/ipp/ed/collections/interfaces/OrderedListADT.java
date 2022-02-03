/**
 * OrderedListADT defines the interface to an ordered list collection. Only
 * comparable elements are stored, kept in the order determined by
 * the inherent relationship among the elements.
 *
 * @author Joaquim Sousa
 * @version 1.0, 08/13/2021
 */
package pt.ipp.ed.collections.interfaces;

public interface OrderedListADT<T> extends ListADT<T>
{
/**
* Adds the specified element to this list at the proper location
*
* @param element the element to be added to this list
*/
public void add (T element);
}
