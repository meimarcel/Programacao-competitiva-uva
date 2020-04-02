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
public class Uva11450_Bottom_up {
    
    public static int preco[][] = new int[25][25], M, C;
    public static boolean reachable[][];
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        while(n > 0) {
            M = input.nextInt();
            C = input.nextInt();
            reachable = new boolean[25][210];
            for(int i = 0; i < C; i++) {
                preco[i][0] = input.nextInt();
                for(int j = 1; j <= preco[i][0]; j++) {
                    preco[i][j] = input.nextInt();
                }
            }
            for(int i = 1; i <= preco[0][0]; i++) {
                if(M - preco[0][i] >= 0) {
                    reachable[0][M - preco[0][i]] = true;
                }
            }
            
            for(int i = 1; i < C; i++) {
                for(int money = 0; money < M; money++) {
                    if(reachable[i - 1][money]) {
                        for(int j = 1; j <= preco[i][0]; j++) {
                            if((money - preco[i][j]) >= 0) {
                                reachable[i][money - preco[i][j]] = true;
                            }
                        }
                    }
                }
            }
            
            
            int ans = 0;    
            for(; ans <= M && !reachable[C-1][ans]; ans++);
            
            if(ans == M + 1) {
                System.out.println("no solution");
            } else {
                System.out.println(M - ans);
            }
            n--;
        }
    }
    
    
    
}
