/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamic_programming;

import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva00108 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()) {
            int n = input.nextInt();
            int matriz[][] = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matriz[i][j] = input.nextInt();
                    if(i > 0) matriz[i][j] += matriz[i-1][j];
                    if(j > 0) matriz[i][j] += matriz[i][j-1];
                    if(i > 0 && j > 0) matriz[i][j] -= matriz[i-1][j-1];
                }
            }
            
            int max = Integer.MIN_VALUE;
            int sum;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    for(int a = i; a < n; a++) {
                        for(int b = j; b < n; b++) {
                            sum = matriz[a][b];
                            if(i > 0) sum -= matriz[i-1][b];
                            if(j > 0) sum -= matriz[a][j-1];
                            if(i > 0 && j > 0) sum += matriz[i-1][j-1];
                            max = Math.max(sum, max);
                        }
                    }
                }
            }
            System.out.println(max);
        }
    }
}
