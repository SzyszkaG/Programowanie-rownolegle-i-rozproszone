package org.example;

import java.util.Random;

public class Traktor extends Thread {
    private String VIN;
    private int maxZbiornik;
    private int paliwo;
    private int zatankowaneLitry;
    private boolean stanPojazdu;
    Random rand= new Random();

    public Traktor(String nr, int pojemnoscZbiornika){
        this.VIN = nr;
        this.maxZbiornik = pojemnoscZbiornika;
        this.paliwo = rand.nextInt(maxZbiornik);;
        this.stanPojazdu = false;
        this.zatankowaneLitry = 0;
    }
    public void tankowanie (int iloscPaliwa){
        System.out.println("Traktor " + this.VIN + " tankuje " + iloscPaliwa + "L paliwa");
        this.paliwo += iloscPaliwa;
        zatankowaneLitry += 1;
    }
    @Override
    public void start() {
        System.out.println("Traktor " + VIN + " ruszył ");
        this.stanPojazdu = true;
        super.start();
    }
    public void stop1() {
        System.out.println("Traktor " + VIN + " zatrzymał się ");
        this.stanPojazdu = false;
    }
    @Override
    public void run() {
        while(stanPojazdu){
            if(this.zatankowaneLitry >= 15 || this.paliwo <= 0) {
                this.stop1();
            }
            else {
                try {
                    if (this.paliwo <= 50) {
                        this.tankowanie(rand.nextInt(maxZbiornik - 15));
                        Thread.sleep(rand.nextInt(2500));
                    } else {
                        System.out.println("Traktor " + this.VIN + " jedzie : paliwo = " + this.paliwo + ", pojemność zbiornika = " + this.maxZbiornik);
                        this.paliwo -= 1;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        }
    }
}
