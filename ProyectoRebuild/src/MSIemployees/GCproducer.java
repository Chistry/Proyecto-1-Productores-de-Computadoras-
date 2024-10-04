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
public class GCproducer extends Worker {
    public GCproducer(Semaphore mutex) {
        super("GraphicCardWorker: ", mutex, 3000, 72, 34, 10, 1); // Valores específicos para ProducerA
    }
}
