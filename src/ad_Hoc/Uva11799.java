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
public class Uva11799 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int caso  = 1;
        int n = input.nextInt();
        input.nextLine();
        while(n > 0) {
            int entrada[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(entrada);
            System.out.printf("Case %d: %d\n",caso++,entrada[entrada.length - 1]);
            n--;
        }
    }
}
