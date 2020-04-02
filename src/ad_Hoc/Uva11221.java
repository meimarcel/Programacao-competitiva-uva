/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva11221 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int cont = 1;
        while(n > 0) {
            String entrada = input.nextLine();
            entrada = entrada.replace("!", "");
            entrada = entrada.replace(".", "");
            entrada = entrada.replace(",", "");
            entrada = entrada.replace("?", "");
            entrada = entrada.replace("'", "");
            entrada = entrada.replace("(", "");
            entrada = entrada.replace(")", "");
            entrada = entrada.replace(" ", "");
            entrada = entrada.toLowerCase();
            double k = Math.sqrt(entrada.length());
            double resto = k % 1.0;
            if(resto == 0.0) {
                int s = (int) k;
                String palavra[] = entrada.split("");
                String box[][] = new String[s][s];
                String p1 = "";
                String p2 = "";
                String p3 = "";
                String p4 = "";
                int init = 0;
                int fim = s;
                for(int i = 0; i < s; i++) {
                    box[i] = Arrays.copyOfRange(palavra, init, fim);
                    init = fim;
                    fim += s;
                }
                for(int i = 0; i < s; i++) {
                    for(int j = 0; j < s; j++) {
                        p1 += box[i][j];
                        p2 += box[s-i-1][s-j-1];
                        p3 += box[s-j-1][s-i-1];
                        p4 += box[j][i];
                    }
                }
                System.out.printf("Case #%d:\n",cont++);
                if(p1.equals(p2) && p2.equals(p3) && p3.equals(p4)) {
                    System.out.println(s);
                } else {
                    System.out.println("No magic :(");
                }
                
            } else {
                System.out.printf("Case #%d:\n",cont++);
                System.out.println("No magic :(");
            }
            n--;
        }           
    } 
}
