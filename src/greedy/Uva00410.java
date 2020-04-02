/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */



public class Uva00410 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cont = 0;
        while(input.hasNextInt()) {
            int c = input.nextInt();
            int s = input.nextInt();
            int pesos[] = new int[2*c];
            int vetor[] = new int[1001];
            List<Pair> camaras = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < s; i++) {
                pesos[i] = input.nextInt();
                vetor[pesos[i]] = i + 1;
                sum += pesos[i];
            }
            int aux[] = Arrays.copyOf(pesos, pesos.length);
            Arrays.sort(aux);
            int fim = (2*c) - 1;
            double imbalance = 0;
            double a = sum / (double)c;
            if(cont != 0) {
                System.out.println();
            }
            System.out.println("Set #"+(++cont));
            for(int i = 0; i < c; i++) {
                imbalance += Math.abs((aux[i] + aux[fim - i]) - a);
                camaras.add(new Pair(vetor[aux[i]],vetor[aux[fim - i]]));
            }
            Collections.sort(camaras, Pair.Comparar);
            /*for(Pair p : camaras) {
                System.out.println(p.x+" "+p.y);
            }*/
            for(int i = 0; i < c; i++) {
                System.out.printf(" %d:",i);
                if(camaras.get(i).x != 0) {
                    System.out.printf(" %d",pesos[camaras.get(i).x - 1]);
                }
                if(camaras.get(i).y != 0) {
                    System.out.printf(" %d",pesos[camaras.get(i).y - 1]);
                }
                System.out.println();
            }
        System.out.printf("IMBALANCE = %.5f\n",imbalance);
           

        }
    }
}

class Pair {
    public int x;
    public int y;
    public int menor;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
        if(this.x > this.y){
            int aux = this.x;
            this.x = this.y;
            this.y = aux;
        }
        menor = (x<y && x != 0)? x:y;
        menor = (menor == 0)? Integer.MAX_VALUE:menor;
    }
    public static Comparator<Pair> Comparar = (Pair p1, Pair p2) -> (int) (p1.menor - p2.menor);
}
