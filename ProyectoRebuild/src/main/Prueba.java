/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;


import MSIemployees.*;
import java.util.concurrent.Semaphore;

/**
 *
 * @author chris
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaphore mutex = new Semaphore(1);
        Worker trab1 = new MBproducer(mutex);
        Worker trab2 = new CPUproducer(mutex);
        Worker trab3 = new RAMproducer(mutex);
        Worker trab4 = new PSproducer(mutex);
        Worker trab5 = new GCproducer(mutex);
        
        Assembler trab6 = new Assembler(mutex, trab1, trab2,trab3,trab4,trab5);
        
        
        
        
        trab1.start();
        trab2.start();
        trab3.start();
        trab4.start();
        trab5.start();
        trab6.start();
        
        
    }
    
}
