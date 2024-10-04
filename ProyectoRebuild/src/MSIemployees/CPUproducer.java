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
public class CPUproducer extends Worker {
    public CPUproducer(Semaphore mutex) {
        super("CPUWorker: ", mutex, 3000, 72, 26, 20, 1); // Valores específicos para ProducerA
    }
}
