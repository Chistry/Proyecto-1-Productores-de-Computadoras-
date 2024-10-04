/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MSIemployees;

/**
 *
 * @author chris
 */

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author chris
 */
public class Assembler extends Thread{
    private String name = "Asssembler: ";
    private int salary = 50;;
    private int ArtiproductionTime=2000;
    private int productionTime  = 48;
    private int production=0;
    private int productionGC=0;
    private Semaphore mutex;
    private int totalsalary = 0;
    private int numproducts = 1;
    private Worker MBproducer;
    private Worker CPUproducer;
    private Worker RAMproducer;
    private Worker PSproducer;
    private Worker GCproducer;
    private int counter = 0;
    


    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    

    
    
    public Assembler(Semaphore mutex, Worker MBproducer, Worker CPUproducer, Worker RAMproducer, Worker PSproducer, Worker GCproducer){
        this.mutex = mutex;
        this.MBproducer = MBproducer;
        this.CPUproducer = CPUproducer;
        this.RAMproducer = RAMproducer;
        this.PSproducer = PSproducer;
        this.GCproducer = GCproducer;
    }
    
    
        
    @Override
    public void run(){
        while(true){
            try{
                if (counter < 6){
                    if (MBproducer.getProduction() >= 2 && CPUproducer.getProduction() >= 3 && RAMproducer.getProduction() >= 4 && PSproducer.getProduction() >= 6){
                        this.mutex.release(); //signal
                        
                        sleep(100);
                        production = ++production;
                        MBproducer.reduceProduction(2);
                        CPUproducer.reduceProduction(3);
                        RAMproducer.reduceProduction(4);
                        PSproducer.reduceProduction(6);
                        
                        sleep(ArtiproductionTime);
                        totalsalary= (salary*productionTime) + totalsalary;
                        System.out.println(this.name);
                        System.out.println("Salario: "+this.totalsalary);
                        System.out.println("Computadores con Graficas: "+ this.productionGC);
                        System.out.println("ElementosFabricados: "+ this.production + "\n");
                        
                        this.counter=++counter;
                    } else {

                        this.mutex.acquire(); //wait
                        totalsalary= (salary*productionTime) + totalsalary;
                        sleep(100);
                        System.out.println(this.name);
                        System.out.println("Salario: "+this.totalsalary);
                        System.out.println("Computadores con Graficas: "+ this.productionGC);
                        System.out.println("ElementosFabricados: "+ this.production + "\n");
                    }
                 
                } else {
                        counter=0;
                        productionGC = ++productionGC;
                        this.mutex.release(); //signal
                        
                        sleep(100);
                        MBproducer.reduceProduction(2);
                        CPUproducer.reduceProduction(3);
                        RAMproducer.reduceProduction(4);
                        PSproducer.reduceProduction(6);
                        GCproducer.reduceProduction(5);
                        
                        sleep(ArtiproductionTime);
                        totalsalary= (salary*productionTime) + totalsalary;
                        System.out.println(this.name);
                        System.out.println("Salario: "+this.totalsalary);
                        System.out.println("Computadores con Graficas: "+ this.productionGC);
                        System.out.println("ElementosFabricados: "+ this.production + "\n");
                    
                }

                
                
                
                
                
                
                
            } catch(InterruptedException ex) {
                Logger.getLogger(Assembler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
