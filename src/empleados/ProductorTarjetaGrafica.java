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

public class ProductorTarjetaGrafica extends Thread {
    private String msg;
    private Almacen almacenTarjetasGraficas;
    private Semaphore semaforoAlmacen;
    private final double salarioPorHora = 34.0;

    public ProductorTarjetaGrafica(Almacen almacenTarjetasGraficas) {
        this.msg = "Productor de Tarjeta Gráfica"; // Mensaje para identificar el hilo
        this.almacenTarjetasGraficas = almacenTarjetasGraficas;
        this.semaforoAlmacen = new Semaphore(1); // Inicializa el semáforo
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaforoAlmacen.acquire();  // Wait

                // Lógica para agregar tarjeta gráfica si hay espacio en el almacén
                if (almacenTarjetasGraficas.agregarItem()) {
                    System.out.println(msg + ": Tarjeta gráfica producida. Almacén actual: " + almacenTarjetasGraficas.getCantidadActual());
                    sleep(3000); // Simula el tiempo de producción de tarjeta gráfica (3 días -> 3 segundos)
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




