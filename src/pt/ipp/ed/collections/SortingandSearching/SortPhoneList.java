/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.SortingandSearching;

/**
 *
 * @author Utilizador
 */
public class SortPhoneList {

    /**
     * Creates an array of Contact objects, sorts them, then prints them.
     */
    public static void main(String[] args) {
        Contact[] friends = new Contact[7];
        friends[0] = new Contact("Clark", "Kent", "610-555-7384");
        friends[1] = new Contact("Bruce", "Wayne", "215-555-3827");
        friends[2] = new Contact("Peter", "Parker", "733-555-2969");
        friends[3] = new Contact("James", "Howlett", "663-555-3984");
        friends[4] = new Contact("Steven", "Rogers", "464-555-3489");
        friends[5] = new Contact("Britt", "Reid", "322-555-2284");
        friends[6] = new Contact("Matt", "Murdock", "243-555-2837");
        SortingAndSearching.selectionSort(friends);
        for (int index = 0; index < friends.length; index++) {
            System.out.println(friends[index]);
        }
    }
}
