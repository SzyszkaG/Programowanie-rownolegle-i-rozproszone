package org.example;

public class Traktorek {
    public static void main(String[] args) {
        Traktor T1 = new Traktor("WVWZZZ6RZBY320099", 1000);
        Traktor T2 = new Traktor("WDSFZZ6RZBY320099", 1200);
        Traktor T3 = new Traktor("SWDZZZ6RZBY320099", 90);
        Traktor T4 = new Traktor("TRYUJN6RZBY320099", 99);
        Traktor T5 = new Traktor("QWAQWA6RZBY320099", 675);

        T1.start();
        T2.start();
        T3.start();
        T4.start();
        T5.start();
    }

}
