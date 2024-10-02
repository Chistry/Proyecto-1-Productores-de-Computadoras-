/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author chris
 */

public class ProductManager extends Thread {
    private int salarioPorHora = 40;
    private int faltas = 0;

    public void run() {
        for (int hora = 0; hora < 24; hora++) {
            if (hora < 16) {
                // Alterna entre ver anime y trabajar
                if (hora % 2 == 0) {
                    // Ve anime
                    System.out.println("Product Manager está viendo anime");
                } else {
                    // Trabaja
                    System.out.println("Product Manager está revisando el proyecto");
                }
            } else {
                // Trabaja exclusivamente
                System.out.println("Product Manager está actualizando el contador de días restantes");
            }

            try {
                Thread.sleep(1000);  // Simular una hora
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
