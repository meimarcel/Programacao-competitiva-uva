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
public class Uva11559 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String entrada[] = input.nextLine().split(" ");
            int valor = Integer.MAX_VALUE;
            for(int i = 0; i < Integer.parseInt(entrada[2]); i++) {
                int custo = input.nextInt();
                input.nextLine();
                int s[] = Arrays.asList(input.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
                Arrays.sort(s);
                if(s[s.length - 1] >= Integer.parseInt(entrada[0])) {
                    int total = custo *  Integer.parseInt(entrada[0]);
                    if(total < valor) {
                        valor = total;
                    }
                }
            }
            if(valor <= Integer.parseInt(entrada[1])) {
                System.out.println(valor);
            } else {
                System.out.println("stay home");
            }
        }
        
    }
    
}
