/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author meimarcel
 */

import java.util.Scanner;
        
public class DPBitmask {
    
    public static int N, target;
    public static double[][] dist = new double[20][20]; 
    public static double[] memo = new double [1 << 16];
    
    public static double matching(int bitmask) {
        
        System.out.println("Bit:"+bitmask);
        if(memo[bitmask] > -0.5) return memo[bitmask];
        if(bitmask == target) return (memo[bitmask] = 0);
        double ans = Double.MAX_VALUE;
        int p1, p2;
        for(p1 = 0; p1 < 2 * N; p1++) {
            if((bitmask & (1 << p1)) == 0) break;
        }
        System.out.println("p1:"+p1);
        
        for(p2 = p1 + 1; p2 < 2 * N; p2++) {
            if((bitmask & (1 << p2)) == 0) {
                System.out.println("p2:"+p2);
                System.out.println();
                ans = Math.min(ans, (dist[p1][p2] + matching(bitmask | (1 << p1) | (1 << p2))));
            }
        }
        return (memo[bitmask] = ans);
        
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i, j, caseNo = 1;
        int[] x = new int[20];
        int[] y = new int[20];
        String[] entrada;
        
        N = input.nextInt();
        input.nextLine();
        while(N != 0) {
            for(i = 0; i < 2 * N; i++) {
                entrada = input.nextLine().split(" ");
                x[i] = Integer.parseInt(entrada[1]);
                y[i] = Integer.parseInt(entrada[2]);
            }
            for(i = 0; i < 2 * N - 1; i++) {
                for(j = i + 1; j < 2 * N; j++) {
                    dist[i][j] = dist[j][i] = Math.hypot(x[i] - x[j], y[i] - y[j]);
                }
            }
            for(i = 0; i < (1 << 16); i++) memo[i] = -1.0;
            target = (1 << (2 * N)) - 1;
            System.out.printf("Case %d: %.2f\n",caseNo++,matching(0));
            N = input.nextInt();
            input.nextLine();
        }
        
    }
    
    
}
