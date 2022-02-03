package pt.ipp.ed.collections.list;

import java.util.Iterator;
import pt.ipp.ed.collections.interfaces.OrderedListADT;

/**
 *
 * @author Utilizador
 */
public class App {
    public static void fp5ex1() {
        System.out.println("=== FP5 EX1 ===");

        OrderedListADT<Integer> array = new ArrayOrderedList<>();
        
        array.add(1);
        array.add(9);
        array.add(8);
        array.add(3);
        array.add(7);
        
        // array.clear();
        System.out.println("first: " + array.first());
        System.out.println("last:  " + array.last());

        //System.out.println(array.toString());
        Iterator<Integer> it = array.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void fp5ex2() {
        System.out.println("=== FP5 EX2 ===");
        int i = 1;
        OrderedListADT<Integer> list = new DoubleLinkedOrderedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        // array.clear();
        System.out.println("first: " + list.first());
        System.out.println("last:  " + list.last());
        
        // o invert devolve um array generico e por isso temos de declarar um array de Object.
        // o invert faz parte da class e não da interface por isso temos de fazer o cast para a class DoubleLinkedOrderedList

        Object vetor[] = ((DoubleLinkedOrderedList)list).invert();

        System.out.println("=== Teste ===");
        for (i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
    }

    public static void fp5ex3() {

    }

    public static void fp5ex4() {

    }

    public static void fp5ex5() {

    }

    public static void main(String[] args) {
        fp5ex1();
        //fp5ex2();
        //fp5ex3();
        //fp5ex4();
        //fp5ex5();

    }

}
