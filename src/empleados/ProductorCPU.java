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

public class ProductorCPU extends Thread {
    private String msg;
    private Almacen almacenCPUs;
    private Semaphore semaforoAlmacen;
    private final double salarioPorHora = 26.0;

    public ProductorCPU(Almacen almacenCPUs) {
        this.msg = "Productor de CPU"; // Mensaje para identificar el hilo
        this.almacenCPUs = almacenCPUs;
        this.semaforoAlmacen = new Semaphore(1); // Inicializa el semáforo
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaforoAlmacen.acquire();  // Wait

                // Lógica para agregar CPU si hay espacio en el almacén
                if (almacenCPUs.agregarItem()) {
                    System.out.println(msg + ": CPU producida. Almacén actual: " + almacenCPUs.getCantidadActual());
                    sleep(3000); // Simula el tiempo de producción de una CPU (3 días -> 3 segundos)
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
