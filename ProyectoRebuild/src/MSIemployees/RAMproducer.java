/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MSIemployees;

import java.util.concurrent.Semaphore;

/**
 *
 * @author chris
 */
public class RAMproducer extends Worker {
    public RAMproducer(Semaphore mutex) {
        super("RAMWorker: ", mutex, 1000, 24, 40, 55, 2); // Valores específicos para ProducerA
    }
}
