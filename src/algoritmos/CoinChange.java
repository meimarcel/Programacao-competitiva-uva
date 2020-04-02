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
public class CoinChange {
    public static int coins[] = {1,5};
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        System.out.println(change(value));
    }
    
    public static int change(int value) {
        int ans = Integer.MAX_VALUE - 100;
        if(value == 0) {
            return 0;
        } 
        if(value < 0) {
            return ans;
        }
        for(int i = 0; i < coins.length; i++) {
            int res = change(value - coins[i]);
            if((res + 1) < ans) {
                ans = res + 1;
            }
        }
        return ans;
    }
    
}
