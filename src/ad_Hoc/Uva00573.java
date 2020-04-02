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

public class Uva00573 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            double entrada[] = Arrays.stream(input.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
            if(entrada[0] == 0){
                break;
            }
            double escalado = 0.0;
            double e = entrada[1];
            double f = entrada[1] * entrada[3] / 100.0;
            
            for(int i = 1; i < Integer.MAX_VALUE; i++) {
                escalado += e;  
                if(escalado > entrada[0]){
                    System.out.println("success on day "+i);
                    break;
                } 
                escalado -= entrada[2];
                if(escalado < 0.0){
                    System.out.println("failure on day "+i);
                    break;
                }              
                e -= f;
                if(e < 0.0) {
                      e = 0;
                }
            }    
        }
    }
}
