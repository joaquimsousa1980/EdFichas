/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.list;

import pt.ipp.ed.collections.interfaces.OrderedListADT;

/**
 *
 * @author Utilizador
 */
public class ArrayListDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ArrayOrderedList<Integer> array = new ArrayOrderedList<Integer>();
//        array.add(3);
//        array.add(99);
//        array.add(2);
//        array.add(123);
//        array.add(8);
//        array.add(1);
//        
//        System.out.println("Primeiro elemento: "+array.first());
//        System.out.println("Ultimo elemento: "+array.last());
//        
//        
//        System.out.println(array.toString());
//        ArrayOrderedList<Phone> array = new ArrayOrderedList<>(10);
//        array.add(new Phone("Joaquim", "962358552"));

        OrderedListADT<Integer> array = new ArrayOrderedList<>();
        array.add(1);
        array.add(2);
        array.add(9);
        array.clear();
        System.out.println(array.first());
        System.out.println(array.last());
        System.out.println(array.toString());

    }

}
