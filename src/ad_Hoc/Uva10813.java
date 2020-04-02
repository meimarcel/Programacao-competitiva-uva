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

/**
 *
 * @author meimarcel
 */
public class Uva10813 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while(n > 0) {
            List<List<String>> cartela = new ArrayList<>();
            cartela.clear();
            List<String> num = new ArrayList<>();        
            int bingo[] = new int[12];
            for(int i = 0; i < 5; i++) {
                cartela.add(Arrays.asList(input.nextLine().split(" ")));
            }
            while (num.size() < 75){
                num.addAll(Arrays.asList(input.nextLine().split(" ")));
            }

            procura: 
            for(int i = 0; i < 75; i++) {
                for(int j = 0; j < 5; j++) {                        
                    if(cartela.get(j).indexOf(num.get(i)) != -1) {
                        int pos = cartela.get(j).indexOf(num.get(i));
                        if(j == 2 && pos >= 2) {
                            pos++;
                        }
                        bingo[j] += 1;
                        bingo[5+pos] += 1;
                        if((j - pos) == 0) {
                            bingo[10] += 1;
                        }
                        if((j + pos) == 4) {
                            bingo[11] += 1;
                        }
                        break;
                    }
                }
                if(bingo[2] == 4 || bingo[7] == 4 || bingo[10] == 4 || bingo[11] == 4) {
                    System.out.println("BINGO after "+(i+1)+" numbers announced");
                    break procura;
                }
                for(int j = 0; j < 12; j++) {
                    if(bingo[j] == 5) {
                        System.out.println("BINGO after "+(i+1)+" numbers announced");
                        break procura;
                    }
                }
            }
   
            n--;
        }
    }
}
