/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author meimarcel
 */
public class Uva00489 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int round = input.nextInt();
        input.nextLine();
        while(input.hasNextLine()) {
            if(round == -1) break;
            String entrada[] = input.nextLine().split("");
            List<String> palavra = Arrays.stream(entrada).distinct().collect(Collectors.toList());
            entrada = input.nextLine().split("");
            String resposta[] = Arrays.stream(entrada).distinct().toArray(String[]::new);
            int erro = 0;
            int acerto = 0;
            System.out.println("Round "+round);
            for(int i = 0; i < resposta.length; i++) {
                if(palavra.indexOf(resposta[i]) == -1) {
                    erro++;
                    if(erro == 7) {
                        break;
                    }
                } else {
                    acerto++;
                    if(acerto == palavra.size()){
                        break;
                    }
                }
            }
            if(erro < 7 && acerto < palavra.size()) {
                System.out.println("You chickened out.");
            } else {
                if(erro == 7) {
                    System.out.println("You lose.");
                }
                if(acerto == palavra.size()) {
                    System.out.println("You win.");
                }
            }
            
            round = input.nextInt();
            input.nextLine();
        }    
    }
}
