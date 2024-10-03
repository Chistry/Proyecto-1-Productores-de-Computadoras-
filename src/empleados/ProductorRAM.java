/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author chris
 */

import almacen.Almacen;
import java.util.concurrent.Semaphore;

public class ProductorRAM extends Thread {
    private String msg;
    private Almacen almacenRAM;
    private Semaphore semaforoAlmacen;
    private final double salarioPorHora = 40.0;

    public ProductorRAM(Almacen almacenRAM) {
        this.msg = "Productor de RAM"; // Mensaje para identificar el hilo
        this.almacenRAM = almacenRAM;
        this.semaforoAlmacen = new Semaphore(1); // Inicializa el semáforo
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaforoAlmacen.acquire();  // Wait

                // Lógica para agregar RAM si hay espacio en el almacén
                if (almacenRAM.agregarItem()) {
                    System.out.println(msg + ": RAM producida. Almacén actual: " + almacenRAM.getCantidadActual());
                    sleep(1000); // Simula el tiempo de producción de RAM (1 día -> 1 segundo)
                } else {
                    System.out.println(msg + ": Almacén lleno. No se puede producir más por ahora.");
                }

                semaforoAlmacen.release();  // Signal
                sleep(1000); // Simula la espera entre intentos de producción
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}



