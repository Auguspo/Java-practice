/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3.Ej4;

/**
 *
 * @author NOICE
 */
public class Test {
        public static void main(String[] args) {
        Robot robot = new Robot();
        Hombre hombre1 = new Hombre();
        hombre1.jugarConRobot(robot);
        Hombre hombre2 = new Hombre();
        hombre2.jugarConRobot(robot);
    }
}
