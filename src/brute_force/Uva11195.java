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
public class Uva11195 {
    
    public static boolean row[], ld[], rd[];
    public static int count = 0, i = 1, ans = 0;
    public static String board[][];
    
    public static void backtrack(int c) {
        if(c == i) {
            ans++;
            return;
        }
        for(int r = 0; r < i; r++) {
            if(!row[r] && !ld[r - c + i - 1] && !rd[r + c] && board[r][c].equals(".")){
                row[r] = ld[r - c + i - 1] = rd[r + c] = true;
                backtrack(c + 1);
                row[r] = ld[r - c + i - 1] = rd[r + c] = false;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            i = input.nextInt();
            input.nextLine();
            if(i == 0) {
                break;
            }      
            board = new String[i][i];
            row = new boolean[i];
            ld = new boolean[2 * i - 1];
            rd = new boolean[2 * i - 1];
            for(int j = 0; j < i; j++) {
                board[j] = input.nextLine().split("");
            }
            ans = 0;
            backtrack(0);
            System.out.println("Case "+(++count)+": "+ans);
            
        }
    }
}
