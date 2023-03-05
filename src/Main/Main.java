/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the templB1234ate in the editor.
 */
package Main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Manage.Management;

/**
 *
 * @author USER
 */
public class Main {

    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            Management m = new Management();
            menu.enterChoice();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
