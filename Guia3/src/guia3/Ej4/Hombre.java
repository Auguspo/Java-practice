/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guia3.Ej4;
import java.util.Scanner;
/**
 *
 * @author NOICE
 */

public class Hombre {
    public void jugarConRobot(Robot robot) {
        Scanner scanner = new Scanner(System.in);
        boolean jugando = true;
        while (jugando) {
            System.out.println("Ingrese la cantidad de pasos que desea que avance o retroceda el robot (ingrese 0 para dormir):");
            int pasos = scanner.nextInt();
            if (pasos == 0) {
                robot.dormir();
                jugando = false;
            } else {
                System.out.println("Ingrese 'a' para avanzar o 'r' para retroceder:");
                String direccion = scanner.next();
                if (direccion.equals("a")) {
                    robot.avanzar(pasos);
                } else if (direccion.equals("r")) {
                    robot.retroceder(pasos);
                } else {
                    System.out.println("Dirección no válida");
                }
                System.out.println("Energía actual del robot: " + robot.energiaActual());
            }
        }
    }
}
