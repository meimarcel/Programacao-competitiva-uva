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
public class Uva10141 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caso = 1;
        while(input.hasNextLine()) {
            String entrada[] = input.nextLine().split(" ");
            if(entrada[0].equals("0") && entrada[1].equals("0")) {
                break;
            } 
            for(int i = 0; i < Integer.parseInt(entrada[0]); i++) {
                String aux = input.nextLine();
            }
            String rep = "";
            double preco = Double.MAX_VALUE;
            int qtd = 0;
            for(int i = 0; i < Integer.parseInt(entrada[1]); i++) {
                String reAux = input.nextLine();
                String aux[] = input.nextLine().split(" ");
                for(int j = 0; j < Integer.parseInt(aux[1]); j++) {
                    input.nextLine();
                }
                if(Integer.parseInt(aux[1]) > qtd) {
                    rep = reAux;
                    preco = Double.parseDouble(aux[0]);
                    qtd = Integer.parseInt(aux[1]);
                }
                else if(Integer.parseInt(aux[1]) == qtd && Double.parseDouble(aux[0]) < preco) {
                    rep = reAux;
                    preco = Double.parseDouble(aux[0]);
                    qtd = Integer.parseInt(aux[1]);
                }
            }
            if(caso != 1) {
                System.out.println();
            }
            System.out.println("RFP #"+(caso++));
            System.out.println(rep);
        }
    }
}
