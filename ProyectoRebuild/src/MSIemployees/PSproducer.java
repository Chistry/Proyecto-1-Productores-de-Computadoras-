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
public class PSproducer extends Worker {
    public PSproducer(Semaphore mutex) {
        super("PowerSuplyWorker: ", mutex, 1000, 24, 16, 35, 3); // Valores específicos para ProducerA
    }
}
