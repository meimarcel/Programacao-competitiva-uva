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
public class Uva11459 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while(n > 0) {
            boolean stop = false;
            String e[] = input.nextLine().split(" ");
            int cont = Integer.parseInt(e[0]);
            int players[] = new int[cont];
            int buracos[] = new int[101];
            for(int i = 0; i < cont; i++) {
                players[i] = 1;
            }
            for(int i = 0; i < Integer.parseInt(e[1]); i++) {
                String p[] = input.nextLine().split(" ");
                buracos[Integer.parseInt(p[0])] = Integer.parseInt(p[1]);
            }
            for(int i = 0; i < Integer.parseInt(e[2]); i++) {
                int j = Integer.parseInt(input.nextLine());
                if(!stop && cont != 0) { 
                    players[i%cont] += j;
                    if(players[i%cont] >= 100) {
                        players[i%cont] = 100;
                        stop = true;
                    } else {      
                        if(buracos[players[i%cont]] != 0) {
                            players[i%cont] = buracos[players[i%cont]];
                        }
                        if(players[i%cont] >= 100) {
                            players[i%cont] = 100;
                            stop = true;
                        }
                    }
                }
            }
            for(int i = 0; i < cont; i++) {
                System.out.printf("Position of player %d is %d.\n",(i+1),players[i]);
            }
            n--;
        }
    } 
}
