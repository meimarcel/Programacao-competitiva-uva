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
public class Uva12247 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            int cartas[] = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(cartas[0] == 0) {
                break;
            }
            int princesa[] = Arrays.copyOfRange(cartas, 0, 3);
            int principe[] = Arrays.copyOfRange(cartas, 3, 5);
            Arrays.sort(principe);
            Arrays.sort(princesa);
            int carta = -1;
            
            if(principe[1] > princesa[2]) {
                if(principe[0] > princesa[2]) {
                    carta = 1;
                }
                else if(principe[0] < princesa[2] && principe[0] > princesa[1]) {
                    carta = princesa[1] + 1;
                }
                else if(principe[0] < princesa[1]) {
                    carta = princesa[2] + 1;
                }
            }
            
            else if(principe[1] < princesa[2] && principe[1] > princesa[1]) {
                if(principe[0] > princesa[1]) {
                    carta = princesa[1] + 1;
                }
                else if(principe[0] < princesa[1]) {
                    carta = -1;
                }
            }  
            boolean cond = true;
            while(cond) {
                cond = false;
                for(int c : cartas) {
                    if(carta == c) {
                        carta++;
                        if(carta == 53) {
                            carta = -1;
                        } else {
                            cond = true;
                        }
                    }
                }
            }
            
            System.out.println(carta);
            
        }
        
    }
}
