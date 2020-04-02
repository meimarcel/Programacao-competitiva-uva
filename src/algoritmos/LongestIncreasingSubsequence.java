/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class LongestIncreasingSubsequence {
    
    public static int array[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
    public static int max = 1;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LIS(array.length);
        System.out.println(max);        
        
    }
    
    public static int LIS(int n) {
        if(n == 1) return 1;
        int ans, max_end = 0;
        
        for(int i = 1; i < n; i++) {       
            ans = LIS(i);
            if(array[i - 1] < array[n - 1] && ans + 1 > max_end) {
                max_end = ans + 1;
            }
        }
   
        if(max < max_end) {
            max = max_end;
        }

        return max_end;
    }
    
}
