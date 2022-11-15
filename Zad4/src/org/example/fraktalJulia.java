package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class fraktalJulia extends Thread{
    final static int N = 4096;
    final static int CUTOFF = 100;

    static int[][] tab = new int[N][N];
    int me;
    double X, Y;

    public static void main(String[] args) throws IOException {
        fraktalJulia[] julia = new fraktalJulia[4];
        for (int i = 0; i < 4; i++) {
            julia[i] = new fraktalJulia(i);
            julia[i].start();
        }

        try {
            for (int i = 0; i < 4; i++) {
                julia[i].join();
            }
        } catch (Exception e) {

        }

        BufferedImage img = new BufferedImage(N, N, BufferedImage.TYPE_INT_ARGB);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int k = tab[i][j];
                Color c;

                if (k >= CUTOFF)
                    c = new Color(0, 0, (float) k / CUTOFF);
                else
                    c = new Color(0, 0, (float) k / CUTOFF);

                img.setRGB(i, j, c.getRGB());
            }
        }

        ImageIO.write(img, "PNG", new File("fraktalJulia.png"));

    }

    public fraktalJulia(int me){
        this.me = me;
        this.X = 2.5 / N;
        this.Y = 2.5 / N;
    }

    public void run() {

        int begin = 0, end = 0;
        if (me == 0) {
            begin = 0;
            end = (N / 4) * 1;
        }
        else if (me == 1) {
            begin = (N / 4) * 1;
            end = (N / 4) * 2;
        }
        else if (me == 2) {
            begin = (N / 4) * 2;
            end = (N / 4) * 3;
        }
        else if (me == 3) {
            begin = (N / 4) * 3;
            end = N;
        }


        for (int i = begin; i < end; i++) {
            for (int j = 0; j < this.N; j++) {
                double real = (i * this.Y) - 1.25;
                double imagine = (j * this.X) - 1.25;

                int k = 0;

                klasa z0 = new klasa(real, imagine);
                klasa z1 = new klasa(-0.023, 0.745);


                while(z0.abs() < 2.0 && k < 100) {
                    k++;
                    z0 = z1.add(z0.pow2());
                }
                this.tab[i][j] = k;
            }
        }
    }

}
