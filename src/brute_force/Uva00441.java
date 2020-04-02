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
public class Uva00441 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean pula = false;
        while (input.hasNextLine()) {
            String entrada[] = input.nextLine().split(" ");
            if(entrada[0].equals("0")) {
                break;
            }
            if(pula) {
                System.out.println();
            } else {
                pula = true;
            }
            int k = Integer.parseInt(entrada[0]);
            for(int i = 0; i < k - 5; i++) {
                for(int j = i + 1; j < k - 4; j++) {
                    for(int z = j + 1; z < k - 3; z++) {
                        for(int a = z + 1; a < k - 2; a++) {
                            for(int b = a + 1; b < k - 1; b++) {
                                for(int c = b + 1; c < k; c++) {
                                    System.out.printf("%s %s %s %s %s %s\n",entrada[i+1],entrada[j+1],entrada[z+1],entrada[a+1],
                                            entrada[b+1],entrada[c+1]);
                                }
                            }
                        }
                    }
                }
            }
        }   
    }
}
