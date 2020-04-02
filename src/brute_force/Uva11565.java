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
public class Uva11565 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while(n > 0) {
            String entrada[] = input.nextLine().split(" ");
            int A = Integer.parseInt(entrada[0]);
            int B = Integer.parseInt(entrada[1]);
            int C = Integer.parseInt(entrada[2]);
            boolean sol = false;
            for(int x = -22; x <= 22 && !sol; x++) if(x * x <= C) {
                for(int y = -100; y <= 100 && !sol; y++) if(y != x && (x * x) + (y * y) <= C) {
                    for(int z = -100; z <= 100 && !sol; z++)
                        if(z != x && z != y && (x+y+z) == A && (x*y*z) == B && (x*x+y*y+z*z) == C) {
                        System.out.printf("%d %d %d\n",x,y,z);
                        sol = true;
                    }
                }
            }
            if(!sol) System.out.println("No solution.");        
            n--;
        }
    }    
}
