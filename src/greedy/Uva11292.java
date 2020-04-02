/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva11292 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextInt()) {
            int n = input.nextInt();
            int m = input.nextInt();
            if(n == 0 && m == 0) {
                break;
            } 
            int dragao[] = new int[n];
            int cavaleiro[] = new int[m];
            for(int i = 0; i < n; i++) {
                dragao[i] = input.nextInt();
            }
            for(int i = 0; i < m; i++) {
                cavaleiro[i] = input.nextInt();
            }
            Arrays.sort(dragao);
            Arrays.sort(cavaleiro);
            int gold = 0, d = 0, k = 0;
            while(d < n && k < m) {
                while(dragao[d] > cavaleiro[k] && k < m) {
                    k++;
                }
                if(k == m) {
                    break;
                }
                gold += cavaleiro[k];
                k++;
                d++;
            }
            if(d == n) {
                System.out.println(gold);
            } else {
                System.out.println("Loowater is doomed!");
            }
            
        }
    }
    
}
