/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package almacen;

/**
 *
 * @author chris
 */
import java.util.concurrent.Semaphore;

public class Almacen {
    private int capacidadMaxima;
    private int cantidadActual;
    private Semaphore mutex = new Semaphore(1);

    public Almacen(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadActual = 0;
    }

    public boolean agregarItem() {
        try {
            mutex.acquire();
            if (cantidadActual < capacidadMaxima) {
                cantidadActual++;
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            mutex.release();
        }
    }

    public boolean retirarItem() {
        try {
            mutex.acquire();
            if (cantidadActual > 0) {
                cantidadActual--;
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } finally {
            mutex.release();
        }
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}

