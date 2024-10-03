package empleados;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chris
 */

import almacen.Almacen;
import java.util.concurrent.Semaphore;

public class ProductorFuente extends Thread {
    private String msg;
    private Almacen almacenFuentes;
    private Semaphore semaforoAlmacen;
    private final double salarioPorHora = 16.0;

    public ProductorFuente(Almacen almacenFuentes) {
        this.msg = "Productor de Fuente"; // Mensaje para identificar el hilo
        this.almacenFuentes = almacenFuentes;
        this.semaforoAlmacen = new Semaphore(1); // Inicializa el semáforo
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaforoAlmacen.acquire();  // Wait

                // Lógica para agregar fuente si hay espacio en el almacén
                if (almacenFuentes.agregarItem()) {
                    System.out.println(msg + ": Fuente producida. Almacén actual: " + almacenFuentes.getCantidadActual());
                    sleep(1000); // Simula el tiempo de producción de fuente (1 día -> 1 segundo)
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


