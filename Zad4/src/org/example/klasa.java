package org.example;

public class klasa {
    private double real;
    private double imagine;

    public klasa(double r, double i){
        this.real = r;
        this.imagine = i;
    }

    public double abs(){
        return Math.sqrt(real * real + imagine * imagine);
    }

    public klasa add(klasa in){
        return new klasa(this.real + in.real, this.imagine + in.imagine);
    }

    public klasa pow2(){
        double r = (this.real * this.real) - (this.imagine * this.imagine);
        double i = (this.real * this.imagine) + (this.imagine * this.real);

        return new klasa(r, i);
    }

}
