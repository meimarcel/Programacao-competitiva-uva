/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva11727 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int cont = 1;
        while(n > 0) {
            String entrada[] = input.nextLine().split(" ");
            Arrays.sort(entrada);
            System.out.println("Case "+(cont++)+": "+entrada[1]);
            n--;
        }
    }
}
