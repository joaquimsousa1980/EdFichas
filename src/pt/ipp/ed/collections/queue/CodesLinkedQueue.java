/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.queue;

import pt.ipp.ed.collections.interfaces.QueueADT;

/**
 *
 * @author Utilizador
 */
public class CodesLinkedQueue {

    /**
     * Encode and decode a message using a key of values stored in* a queue.
     */
    public static void main(String[] args) {
        System.out.println("**************  TESTING THE CIPHER  **************\n");
        int[] key = {5, 12, -3, 8, -9, 4, 10};
        Integer keyValue;
        String encoded = "", decoded = "";
        String message = "All programmers are playwrights and all "
                + "computers are lousy actors.";
        QueueADT<Integer> keyQueue1 = new LinkedQueue<>();
        QueueADT<Integer> keyQueue2 = new LinkedQueue<>();
        /**
         * load key queue
         */
        for (int scan = 0; scan < key.length; scan++) {
            keyQueue1.enqueue(key[scan]);
            keyQueue2.enqueue(key[scan]);
        }
// encode message
        for (int scan = 0; scan < message.length(); scan++) {
            keyValue = keyQueue1.dequeue();
            encoded += (char) ((int) message.charAt(scan) + keyValue);
            keyQueue1.enqueue(keyValue);
        }
        System.out.println("Encoded Message:\n" + encoded + "\n");
// decode message
        for (int scan = 0; scan < encoded.length(); scan++) {
            keyValue = keyQueue2.dequeue();
            decoded += (char) ((int) encoded.charAt(scan) - keyValue);
            keyQueue2.enqueue(keyValue);
        }
        System.out.println("Decoded Message:\n" + decoded);
    }
}
