package pt.ipp.ed.main;

import pt.ipp.ed.collections.list.LinkedList;

//import java.util.LinkedList;
public class ListaLigadaDemo {

    public static void main(String[] args) {
        LinkedList<String> lista = new LinkedList<>();

        lista.addFirst("A");
        lista.addFirst("B");
        lista.addFirstV0("C");
        lista.addFirst("D");
        System.out.println(lista.toString());
        System.out.println("Removeu: "+lista.removeFirst());
        System.out.println(lista.toString());
        System.out.println("Removeu: "+lista.removeFirst());
        System.out.println(lista.toString());
        System.out.println("Removeu: "+lista.removeFirst());
        System.out.println(lista.toString());
        System.out.println("Removeu: "+lista.removeFirst());
        System.out.println(lista.toString());

        
    }
}
