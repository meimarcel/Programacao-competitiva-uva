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
public class Uva12455 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while(t > 0) {
            boolean find = false;
            int n = input.nextInt();
            int p = input.nextInt();
            input.nextLine();
            String barras[] = input.nextLine().split(" ");
            for(int i = 0; i < (1 << p); i++) {
                int sum = 0;
                for(int j = 0; j < p; j++) {
                    if((i & (1 << j)) != 0) {
                        sum += Integer.parseInt(barras[j]); 
                    }
                }
                if(sum == n) {
                    find = true;
                    break;
                }
            }
            if(find) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            } 
            t--;
        }
    }
}
