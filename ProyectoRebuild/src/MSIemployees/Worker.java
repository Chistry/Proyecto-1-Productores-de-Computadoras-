/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MSIemployees;


import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author chris
 */
public class Worker extends Thread{
    private String name;
    private int salary;
    private int ArtiproductionTime;
    private int productionTime;
    private int maxproduction;
    private int production;
    private Semaphore mutex;
    private int totalsalary = 0;
    private int numproducts;


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getArtiproductionTime() {
        return ArtiproductionTime;
    }

    public void setArtiproductionTime(int ArtiproductionTime) {
        this.ArtiproductionTime = ArtiproductionTime;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public int getMaxproduction() {
        return maxproduction;
    }

    public void setMaxproduction(int maxproduction) {
        this.maxproduction = maxproduction;
    }

    public int getProduction() {
        return production;
    }

    public void setProduction(int production) {
        this.production = production;
    }

    public int getTotalsalary() {
        return totalsalary;
    }

    public void setTotalsalary(int totalsalary) {
        this.totalsalary = totalsalary;
    }

    public int getNumproducts() {
        return numproducts;
    }

    public void setNumproducts(int numproducts) {
        this.numproducts = numproducts;
    }


    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }
    
    
    public void reduceProduction(int amount) {
        if (this.production >= amount) {
            this.production -= amount;
        } else {
            System.out.println("No hay suficientes productos para descontar.");
        }
    }

    
    
    public Worker(String name, Semaphore mutex, int ArtiproductionTime, int productionTime,int salary, int maxproduction, int numproducts){
        this.name = name;
        this.mutex = mutex;
        this.ArtiproductionTime = ArtiproductionTime;
        this.salary= salary;
        this.maxproduction =  maxproduction;
        this.productionTime = productionTime;
        this.numproducts = numproducts;
        
    }
    
    
        
    @Override
    public void run(){
        while(true){
            try{
                
                if (production < maxproduction){
                    this.mutex.release(); //signal
                    sleep(100);
                    sleep(ArtiproductionTime);
                    production = numproducts+production;
                } 
                if (production >= maxproduction){
                    
                    this.mutex.acquire(); //wait
                    production = maxproduction;
                    totalsalary= (salary*productionTime) + totalsalary;
                    sleep(100);
                    System.out.println(this.name);
                    System.out.println("Salario: "+this.totalsalary);
                    System.out.println("ElementosFabricados: "+ this.production + "\n");
                    break;
                }
                
                totalsalary= (salary*productionTime) + totalsalary;
                System.out.println(this.name);
                System.out.println("Salario: "+this.totalsalary);
                System.out.println("ElementosFabricados: "+ this.production + "\n");
                
                
                
                
                
            } catch(InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
