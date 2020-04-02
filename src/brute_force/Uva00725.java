/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brute_force;

import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva00725 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        boolean first = true;
        while(n != 0) {
            boolean cond = true;
            if(!first) {
                System.out.println();
            } else {
                first = false;
            }
            for(int fghij = 1234; fghij <= 98765 / n; fghij++) {
                int abcde = fghij * n;
                int tmp;
                int used = (fghij < 10000)? 1 : 0;
                tmp = abcde;
                while(tmp != 0) {
                    used |= 1 << (tmp % 10);
                    tmp /= 10;
                }
                tmp = fghij;
                while(tmp != 0) {
                    used |= 1 << (tmp % 10);
                    tmp /= 10;
                }
                if(used == (1 << 10) - 1) {cond = false; System.out.printf("%05d / %05d = %d\n",abcde, fghij, n);}
            }
            if(cond) {
                System.out.printf("There are no solutions for %d.\n",n);  
            }      
            n = input.nextInt();
            
        }      
    }
    
}
