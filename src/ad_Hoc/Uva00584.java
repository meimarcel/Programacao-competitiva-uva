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
public class Uva00584 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String entrada[] = input.nextLine().split(" ");
            if(entrada[0].equals("Game")) {
                break;
            }
            int pontos = 0;
            int roud = 1;
            int i = 0;
            while(i < entrada.length) {
                if(!entrada[i].equals("X") && !entrada[i+1].equals("/")) {
                    pontos += Integer.parseInt(entrada[i]) + Integer.parseInt(entrada[i+1]);
                    i += 2;
                } 
                else if(entrada[i+1].equals("/")) {
                    if(!entrada[i+2].equals("X")) { 
                        pontos += 10 + Integer.parseInt(entrada[i+2]);
                    } else {
                        pontos += 20;
                    }
                    i += 2;
                    if(roud == 10) {
                        break;
                    }
                }
                else if(entrada[i].equals("X")) {
                    if(!entrada[i+2].equals("/") && !entrada[i+1].equals("X") && !entrada[i+2].equals("X")) {
                        pontos +=  10 + Integer.parseInt(entrada[i+1]) + Integer.parseInt(entrada[i+2]);
                    } else {
                        if(entrada[i+2].equals("/")) {
                            pontos += 20;
                        } else {
                            if(entrada[i+1].equals("X") && !entrada[i+2].equals("X")) {
                                pontos += 20 + Integer.parseInt(entrada[i+2]);
                            } else {
                                pontos += 30;
                            }
                        }
                    }
                    i += 1;
                    if(roud == 10) {
                        break;
                    }
                }
                roud++;
            }
            System.out.println(pontos);
        }
        
    } 
    
}
