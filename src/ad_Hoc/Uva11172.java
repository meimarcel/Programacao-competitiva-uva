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
public class Uva11172 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        for(;n > 0; n--){
            String entrada[] = input.nextLine().split(" ");
            int x = Integer.parseInt(entrada[0]);
            int y = Integer.parseInt(entrada[1]);
            if(x == y) {
                System.out.println("=");
            } 
            else if(x > y) {
                System.out.println(">");
            } else {
                System.out.println("<");
            }
        }
    }
    
}
