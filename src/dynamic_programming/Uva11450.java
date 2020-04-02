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
public class Uva11450 {
    
    public static int preco[][] = new int[25][25], M, C;
    public static int memo[][] = new int[210][25];
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n > 0) {
            M = input.nextInt();
            C = input.nextInt();
            for(int i = 0; i < C; i++) {
                preco[i][0] = input.nextInt();
                for(int j = 1; j <= preco[i][0]; j++) {
                    preco[i][j] = input.nextInt();
                }
            }
            for(int i = 0; i < 210; i++) {
                for(int j = 0; j < 25; j++) {
                    memo[i][j] = -1;
                }
            }
            int ans = shop(M,0);
            if(ans < 0) {
                System.out.println("no solution");
            } else {
                System.out.println(ans);
            }
            n--;
        }
    }
    
    public static int shop(int money, int g) {
        if(money < 0) return -1000000;
        if(g == C) return M - money;
        if(memo[money][g] != -1) return memo[money][g];
        int ans = -1;
        for(int model = 1; model <= preco[g][0]; model++) {
            ans = Math.max(ans, shop(money - preco[g][model], g+1));
        }
        return memo[money][g] = ans;
    }
    
}
