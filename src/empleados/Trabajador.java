/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author chris
 */

public abstract class Trabajador extends Thread {
    protected int salarioPorHora;
    protected final int horasDeTrabajo = 24;  // Todos los trabajadores (excepto Product Manager) trabajan 24 horas

    public Trabajador(int salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }

    public abstract void trabajar();

    @Override
    public void run() {
        // Lógica de trabajo durante 24 horas al día
        while (true) {
            trabajar();
            try {
                Thread.sleep(1000);  // Simular tiempo de espera o producción
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



// Otras clases para los demás tipos de trabajadores...
