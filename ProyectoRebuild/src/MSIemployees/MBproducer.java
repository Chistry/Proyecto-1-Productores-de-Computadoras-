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
public class MBproducer extends Worker {
    public MBproducer(Semaphore mutex) {
        super("MotherBoardWorker: ", mutex, 3000, 72, 20, 25, 1); // Valores específicos para ProducerA
    }
    
    
}
    

