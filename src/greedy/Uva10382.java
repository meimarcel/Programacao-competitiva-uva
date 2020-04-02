/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */



public class Uva10382 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Intervalo> lista = new ArrayList<>();
        while(input.hasNextInt()) {
            int n = input.nextInt();
            double l = input.nextInt();
            double w = input.nextInt();        
            for(int i = 0; i < n; i++) {
                double x = input.nextDouble();
                double r = input.nextDouble();
                if((2*r) >= w) {
                    lista.add(new Intervalo(x,r,w));
                }
            }
            Collections.sort(lista);
            
            int ans = 0;
            double min = 0;
            if(!lista.isEmpty()) {
                if(lista.get(0).inicio > 0.0) {
                    ans = -1;
                } else {
                    double max = 0;
                    Intervalo anterior = lista.get(0);
                    for(int i = 0; i < lista.size(); i++) {
                        if(lista.get(i).inicio > anterior.fim) {
                            ans = -1;
                            break;
                        }

                        for(int j = i; j < lista.size(); j++) {
                            if(lista.get(j).inicio <= min && lista.get(j).fim > max) {
                                max = lista.get(j).fim;
                                i = j;
                            }
                        }
                        ans++;
                        anterior = lista.get(i);
                        min = anterior.fim;
                        if(min >= l) {
                            break;
                        }

                    }
                }
            }
            if(min < l) {
                ans = -1;
            }
            System.out.println(ans);
            lista.clear();
        }
    }
    
}

class Intervalo implements Comparable<Intervalo>{
    public double centro;
    public double raio;
    public double inicio;
    public double fim;
    
    public Intervalo(double centro, double raio, double w) {
        this.centro = centro;
        this.raio = raio;
        double aux = Math.sqrt((raio*raio) - ((w/2.0)*(w/2.0)) );
        this.inicio = this.centro - aux;
        this.fim = this.centro + aux;
    }
    
    @Override
    public int compareTo(Intervalo i) {
        return (this.inicio > i.inicio)? 1 : -1;
    }

}
