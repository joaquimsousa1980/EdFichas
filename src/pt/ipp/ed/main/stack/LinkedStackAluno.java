
package pt.ipp.ed.main.stack;

import pt.ipp.ed.collections.list.Aluno;
import pt.ipp.ed.collections.stack.LinkedStackV0;
import pt.ipp.ed.collections.interfaces.StackADT;

/**
 *
 * @author Utilizador
 */
public class LinkedStackAluno {

    public static void main(String[] args) {
        //LinkedStack<Aluno> aluno = new LinkedStackV0<>();
        StackADT<Aluno> aluno = new LinkedStackV0<>();
        
        System.out.println("A stack esta vazia?: " + aluno.isEmpty());
        System.out.println("Numero de elementos: " + aluno.size());
        aluno.push(new Aluno(1234, "Joaquim"));
        aluno.push(new Aluno(2345, "Gil"));
        aluno.push(new Aluno(3456, "Celia"));
        
        System.out.println("Topo: " + aluno.peek());
        System.out.println("Removeu: " + aluno.pop());
        System.out.println("Novo Topo: " + aluno.peek());
        
        aluno.push(new Aluno(4567, "Paula"));
        System.out.println("Removeu: " + aluno.pop());
        System.out.println("Novo Topo: " + aluno.peek());
        System.out.println("A stack esta vazia?: " + aluno.isEmpty());
        System.out.println("Numero de elementos: " + aluno.size());

    }
}
