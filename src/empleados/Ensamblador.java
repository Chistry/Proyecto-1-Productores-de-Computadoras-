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

public class Ensamblador extends Trabajador {
    private Almacen placasBase;
    private Almacen cpus;
    private Almacen ram;
    private Almacen fuentes;
    private Almacen tarjetasGraficas;
    private boolean conTarjetaGrafica;

    public Ensamblador(Almacen placasBase, Almacen cpus, Almacen ram, Almacen fuentes, Almacen tarjetasGraficas) {
        super(50); // Ensamblador cobra $50 por hora
        this.placasBase = placasBase;
        this.cpus = cpus;
        this.ram = ram;
        this.fuentes = fuentes;
        this.tarjetasGraficas = tarjetasGraficas;
        this.conTarjetaGrafica = false;
    }

    @Override
    public void trabajar() {
        while (true) {
            // Verificar si hay suficientes componentes
            if (placasBase.retirarItem() && placasBase.retirarItem() && cpus.retirarItem() && cpus.retirarItem() && cpus.retirarItem()
                    && ram.retirarItem() && ram.retirarItem() && ram.retirarItem() && ram.retirarItem() && fuentes.retirarItem() && fuentes.retirarItem()
                    && fuentes.retirarItem() && fuentes.retirarItem() && fuentes.retirarItem() && fuentes.retirarItem()) {
                
                if (conTarjetaGrafica) {
                    if (tarjetasGraficas.retirarItem() && tarjetasGraficas.retirarItem() && tarjetasGraficas.retirarItem() 
                            && tarjetasGraficas.retirarItem() && tarjetasGraficas.retirarItem()) {
                        System.out.println("Ensamblando computadora con tarjeta gráfica...");
                    } else {
                        System.out.println("No hay suficientes tarjetas gráficas.");
                    }
                    conTarjetaGrafica = false; // Reiniciar el ciclo de producción
                } else {
                    System.out.println("Ensamblando computadora estándar...");
                    conTarjetaGrafica = true;
                }

                try {
                    Thread.sleep(2 * 24 * 60 * 60 * 1000);  // Ensamblaje tarda 2 días
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println("No hay suficientes componentes para ensamblar.");
                try {
                    Thread.sleep(5000);  // Esperar antes de intentar nuevamente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

