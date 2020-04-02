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
public class Uva00696 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String pos[] = input.nextLine().split(" ");
            if(pos[0].equals("0") && pos[1].equals("0")) {
                break;
            }
            int k = 0;
            int maior = Integer.parseInt(pos[0]) < Integer.parseInt(pos[1])? Integer.parseInt(pos[1]) : Integer.parseInt(pos[0]);
            int menor = Integer.parseInt(pos[0]) > Integer.parseInt(pos[1])? Integer.parseInt(pos[1]) : Integer.parseInt(pos[0]);
            if(menor == 1) {
                k = maior;
            } 
            else if(menor == 2) {
                k = maior / 4 * 4 + (maior%4 == 1? 2 : (maior%4 >= 2? 4 : 0));
            } else {
                k = (int)Math.ceil(Integer.parseInt(pos[0]) * Integer.parseInt(pos[1]) / 2.0);
            }
            System.out.printf("%d knights may be placed on a %d row %d column board.\n", k,Integer.parseInt(pos[0]),Integer.parseInt(pos[1]));
        }
        
    }
}
