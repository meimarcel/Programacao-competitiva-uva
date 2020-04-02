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
public class TravellingSalesmanProblem {
    public static int matriz[][] = {{0, 20, 42, 35}, 
                         {20, 0, 30, 34}, 
                         {42, 30, 0, 12}, 
                         {35, 34, 12, 0}};;
    
    public static void main(String[] args) {
        int ans = Integer.MAX_VALUE;
        System.out.println(TSP(0,1,4,0,ans));
        
    }
    
    public static int TSP(int curPos, int bitmask, int n, int cost, int ans) {
        if(bitmask == ((1 << n) - 1)) {
            if(matriz[curPos][0] > 0) {
                ans = Math.min(ans, cost + matriz[curPos][0]);
                return ans;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if(matriz[curPos][i] > 0) {
                if((bitmask & (1 << i)) == 0) {
                    ans = TSP(i, bitmask | (1 << i), n, cost + matriz[curPos][i], ans);
                }
            }
        }
        
        return ans;
    }
    
    
}
