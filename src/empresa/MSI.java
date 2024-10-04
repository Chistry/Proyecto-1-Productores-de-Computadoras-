/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresa;

/**
 *
 * @author chris
 */

import almacen.Almacen;
import empleados.*;

public class MSI {
    private Almacen almacenPlacasBase;
    private Almacen almacenCPUs;
    private Almacen almacenRAM;
    private Almacen almacenFuentes;
    private Almacen almacenTarjetasGraficas;

    private ProductorPlacaBase productorPlacaBase;
    private ProductorCPU productorCPU;
    private ProductorRAM productorRAM;
    private ProductorFuente productorFuente;
    private ProductorTarjetaGrafica productorTarjeta;
    private Ensamblador ensamblador;
    private ProjectManager projectManager;
    private Director director;

    public MSI() {
        // Inicializar almacenes
        almacenPlacasBase = new Almacen(25);
        almacenCPUs = new Almacen(20);
        almacenRAM = new Almacen(55);
        almacenFuentes = new Almacen(35);
        almacenTarjetasGraficas = new Almacen(10);

        // Inicializar trabajadores
        productorPlacaBase = new ProductorPlacaBase(almacenPlacasBase);
        productorCPU = new ProductorCPU(almacenCPUs);
        productorRAM = new ProductorRAM(almacenRAM);
        productorFuente = new ProductorFuente(almacenFuentes);
        productorTarjeta = new ProductorTarjetaGrafica(almacenTarjetasGraficas);
        ensamblador = new Ensamblador(almacenPlacasBase, almacenCPUs, almacenRAM, almacenFuentes, almacenTarjetasGraficas);

        // Inicializar project manager y director
        projectManager = new ProjectManager();
        director = new Director();
    }

    // Método para iniciar la simulación
    public void iniciarSimulacion() {
        new Thread(productorPlacaBase).start();
        new Thread(productorCPU).start();
        new Thread(productorRAM).start();
        new Thread(productorFuente).start();
        new Thread(productorTarjeta).start();
        new Thread(ensamblador).start();
        new Thread(projectManager).start();
        new Thread(director).start();
    }
}

