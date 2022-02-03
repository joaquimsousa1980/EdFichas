/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.ed.collections.TournamentMaker;

import pt.ipp.ed.collections.list.*;

/**
 *
 * @author Utilizador
 */
public class Phone {

    private String name;
    private String phone;

    public Phone() {
        name = "";
        phone = "";
    }

    public Phone(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return (name + " " + phone);
    }

    public boolean equals(Phone other) {
        return (name == other.name) && (phone == other.phone);

    }
}
