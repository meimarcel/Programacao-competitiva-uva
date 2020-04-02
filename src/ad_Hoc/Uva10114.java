/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva10114 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String entrada[] = input.nextLine().split(" ");
            if(Integer.parseInt(entrada[0]) < 0){
                break;
            }
            String d[][] = new String[Integer.parseInt(entrada[3])][];
            for(int i = 0; i < Integer.parseInt(entrada[3]); i++) {
                d[i] = input.nextLine().split(" ");
            }
            double carro = Double.parseDouble(entrada[1]) + Double.parseDouble(entrada[2]);
            int cont = 0;
            double valor = Double.parseDouble(entrada[2]) / Double.parseDouble(entrada[0]);
            double pagar = Double.parseDouble(entrada[2]);
            for(int i = 0; i <= Integer.parseInt(entrada[0]); i++) {
                if((cont + 1) < Integer.parseInt(entrada[3])) {
                    if(i == Integer.parseInt(d[cont+1][0])) {
                        cont++;
                    }
                }
                
                carro = carro - (carro * Double.parseDouble(d[cont][1]));
                if(i != 0) {
                    pagar -= valor; 
                }
                if(pagar < carro) {
                    if(i == 1) {
                        System.out.println("1 month");           
                    } else {
                        System.out.println(i+" months");
                    }
                    break;
                }
            }
        }
    }
    
}
