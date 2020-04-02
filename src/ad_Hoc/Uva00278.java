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
public class Uva00278 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while(n > 0) {
            String entrada[] = input.nextLine().split(" ");
            if(entrada[0].equals("r") || entrada[0].equals("Q")) {
                System.out.println(Math.min(Integer.parseInt(entrada[1]), Integer.parseInt(entrada[2])));
            }
            else if(entrada[0].equals("k")) {
                System.out.printf("%.0f\n",(Math.ceil(Integer.parseInt(entrada[1]) * Integer.parseInt(entrada[2]) / 2.0)));
            }
            else if(entrada[0].equals("K")) {
                System.out.printf("%.0f\n",(Math.ceil((Integer.parseInt(entrada[1]) / 2.0)) * Math.ceil((Integer.parseInt(entrada[2]) / 2.0))) );
            }
            if(!entrada[0].equals("")) {
                n--;
            }
        }
    }
}
