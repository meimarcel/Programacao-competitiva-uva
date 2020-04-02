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
public class Uva10945 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String entrada = input.nextLine();
            if(entrada.equals("DONE")) break;
            entrada = entrada.replace("!", "");
            entrada = entrada.replace(".", "");
            entrada = entrada.replace(",", "");
            entrada = entrada.replace("?", "");
            entrada = entrada.replace("'", "");
            entrada = entrada.replace(" ", "");
            entrada = entrada.toLowerCase();
            String palavra[] = entrada.split("");
            int j = palavra.length - 1;
            boolean palindromo = true;
            for(int i = 0; i < palavra.length / 2; i++) {
                if(!palavra[i].equals(palavra[j-i])) {
                    palindromo = false;
                    break;
                }
            }
            System.out.println(palindromo? "You won't be eaten!":"Uh oh.."); 
            
        }
    }
    
}
