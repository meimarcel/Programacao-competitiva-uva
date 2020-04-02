/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva11498 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int k;
        while((k = input.nextInt()) != 0) {
            input.nextLine();
            String entrada[] = input.nextLine().split(" ");
            int x = Integer.parseInt(entrada[0]);
            int y = Integer.parseInt(entrada[1]);
            for(int i = k; i > 0; i--){
                entrada = input.nextLine().split(" ");
                int x1 = Integer.parseInt(entrada[0]);
                int y1 = Integer.parseInt(entrada[1]);
                if(x1 == x || y1 == y) {
                    System.out.println("divisa");
                }
                else if(x1 < x && y1 > y) {
                    System.out.println("NO");
                }
                else if(x1 > x && y1 > y) {
                    System.out.println("NE");
                }
                else if(x1 > x && y1 < y) {
                    System.out.println("SE");
                } else {
                    System.out.println("SO");
                }
            }
        }
    }    
}
