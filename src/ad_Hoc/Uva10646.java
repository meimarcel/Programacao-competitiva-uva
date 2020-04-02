/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author meimarcel
 */
public class Uva10646 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int caso = 1;
        while(n > 0) {
            int cont = 0;
            List<String> baralho = new ArrayList<>();
            while(true) {
                List<String> entrada = Arrays.stream(input.nextLine().split(" ")).collect(Collectors.toList());
                baralho.addAll(entrada);
                cont += entrada.size();
                if(cont >= 52) {
                    break;
                }
            }
            int y = -1;
            int top = 26;
            int x = 0;
            for(int i = 0; i < 3; i++) {
                String carta = baralho.get(top);
                try {
                    x = Integer.parseInt(carta.split("")[0]);
                } catch(Exception e) {
                    x = 10;
                }
                y += x;
                top -= (10 - x);
                top--;
            }
            if(y <= top) {
                System.out.printf("Case %d: %s\n", (caso++), baralho.get(y));
            } else {
                int a = y - top;
                System.out.printf("Case %d: %s\n", (caso++), baralho.get(26+a));
            }
            n--;
        }    
    }
}
