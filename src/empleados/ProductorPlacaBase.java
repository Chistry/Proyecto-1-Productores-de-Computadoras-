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

public class ProductorPlacaBase extends Thread {
    private String msg;
    private Almacen almacenPlacasBase;
    private Semaphore semaforoAlmacen;
    private final double salarioPorHora = 20.0;

    public ProductorPlacaBase(Almacen almacenPlacasBase) {
        this.msg = "Productor de Placa Base"; // Mensaje para identificar el hilo
        this.almacenPlacasBase = almacenPlacasBase;
        this.semaforoAlmacen = new Semaphore(1); // Inicializa el semáforo
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaforoAlmacen.acquire();  // Wait

                // Lógica para agregar placa base si hay espacio en el almacén
                if (almacenPlacasBase.agregarItem()) {
                    System.out.println(msg + ": Placa base producida. Almacén actual: " + almacenPlacasBase.getCantidadActual());
                    sleep(3000); // Simula el tiempo de producción de una placa base (3 días -> 3 segundos)
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

