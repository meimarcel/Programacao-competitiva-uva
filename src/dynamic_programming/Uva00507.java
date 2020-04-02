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
public class Uva00507 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int route = 0;
        int n = input.nextInt();
        while(n > 0) {  
            int s = input.nextInt();
            int casas[] = new int[s-1];
            for(int i = 0; i < (s - 1); i++) {
                casas[i] = input.nextInt();
            }
            
            int temp = 1, ans = 0, sum = 0, init = Integer.MAX_VALUE, fim = 0;
            for(int i = 0; i < (s - 1); i++) {
                sum += casas[i];

                                
                if(sum >= ans) {
                    if(sum > ans || (sum == ans && (i+2) - temp > fim - init)) {
                        init = temp;
                        fim  = i + 2;
                    }
                    ans = sum;
                }
                
                if(sum < 0) {
                    sum = 0;     
                    temp = i+2;        
                }  
                
    
            }

            if(ans > 0) {
                System.out.printf("The nicest part of route %d is between stops %d and %d\n",(++route),init,fim);
            } else {
                System.out.printf("Route %d has no nice parts\n",(++route),init,fim);
            }

            n--;
        }
        
    }
    
}
