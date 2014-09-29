/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controladores.ControlLogin;
import vistas.Login;

/**
 *
 * @author Alan
 */
public class Main {
    public static void main(String[] args) {
        Login login = new Login();
        ControlLogin cl = new ControlLogin(login);
        
    }
}
