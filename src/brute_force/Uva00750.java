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
public class Uva00750 {
    
    public static int row[], TC, a, b, lineCounter;
    
    public static boolean place(int r, int c) {
        for(int prev = 0; prev < c; prev++) {
            if(row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
                return false;
            }
        }
        return true;
    }
    
    public static void backtrack(int c) {
        if(c == 8 && row[b] == a) {
            System.out.printf("%2d      %d",++lineCounter, row[0] + 1);
            for(int i =1; i < 8; i++) {
                System.out.printf(" %d",row[i] + 1);
            }
            System.out.println();
        }
        for(int r = 0; r < 8; r++) {
            if(place(r,c)) {
                row[c] = r;
                backtrack(c + 1);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n > 0) {
            a = input.nextInt() - 1;
            b = input.nextInt() - 1;
            row = new int[8];
            lineCounter = 0;
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8");
            System.out.println();
            backtrack(0);
            if(n != 1) {
                System.out.println();
            }
            n--;
        }  
    }
}
