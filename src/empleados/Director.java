/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;
import java.util.Random;

/**
 *
 * @author chris
 */


public class Director extends Thread {
    private int salarioPorHora = 60;

    @Override
    public void run() {
        while (true) {
            // Revisar cuántos días faltan para la entrega
            Random random = new Random();
            int horaAleatoria = random.nextInt(24);

            for (int hora = 0; hora < 24; hora++) {
                if (hora == horaAleatoria) {
                    // Revisar al Product Manager
                    System.out.println("Director está revisando al Product Manager");
                } else {
                    // Trabaja en tareas administrativas
                    System.out.println("Director está haciendo labores administrativas");
                }

                try {
                    Thread.sleep(1000);  // Simular una hora
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

