package pt.ipp.ed.main.stack;

import pt.ipp.ed.collections.stack.ArrayStack;
import java.util.Scanner;

/**
 *
 * @author Utilizador
 */
public class ArrayStackCalcPostfix {

    private static boolean isInteger(String entrada) {
        return entrada != null && entrada.matches("[-10-9]*");
    }

    public static void main(String[] args) {
        String entrada = "123";
        int resultado = 0;
        int tamInput;
        Scanner tam = new Scanner(System.in);
        System.out.println("Enter a inicial capacity");
        tamInput = tam.nextInt();
        ArrayStack<Integer> s = new ArrayStack<>(tamInput);

        System.out.println("stack criada tamanho: " + s.size());

        Scanner scanner = new Scanner(System.in);

        while (entrada.compareTo("=") != 0) {

            System.out.print("Entrada: ");
            entrada = scanner.nextLine();
            switch (entrada) {
                case "+":
                    s.info();
                    resultado = s.pop() + s.pop();
                    s.push(resultado);
                    break;
                case "-":
                    s.info();
                    resultado = s.pop() - s.pop();
                    s.push(resultado);
                    //resultado = 0;
                    break;
                case "/":
                    s.info();
                    int a = s.pop();
                    int b = s.pop();
                    resultado = b / a;
                    s.push(resultado);
                    break;
                case "*":
                    s.info();
                    resultado = s.pop() * s.pop();
                    s.push(resultado);

                    break;
                default:
                    if (isInteger(entrada)) {
                        Integer temp = Integer.parseInt(entrada);
                        s.push(temp);
                    }
                    resultado = 0;
            }
        }
        s.info();
    }
}
