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
public class Uva11507 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while(n != 0) {
            String entrada[] = input.nextLine().split(" ");
            String atual = "+x";
            for(String s : entrada) {
                if(s.equals("+y")) {
                    if(atual.equals("-y")) {
                        atual = "+x";
                    }
                    else if(atual.equals("+y")) {
                        atual = "-x";
                    }
                    else if(atual.equals("+x") || atual.equals("No")) {
                        atual = "+y";
                    }
                    else if(atual.equals("-x")) {
                        atual = "-y";
                    }
                }
                else if(s.equals("-y")) {
                    if(atual.equals("-y")) {
                        atual = "-x";
                    }
                    else if(atual.equals("+y")) {
                        atual = "+x";
                    }
                    else if(atual.equals("+x") || atual.equals("No")) {
                        atual = "-y";
                    }
                    else if(atual.equals("-x")) {
                        atual = "+y";
                    }     
                }
                else if(s.equals("+z")) {
                    if(atual.equals("-z")) {
                        atual = "+x";
                    }
                    else if(atual.equals("+z")) {
                        atual = "-x";
                    }
                    else if(atual.equals("+x") || atual.equals("No")) {
                        atual = "+z";
                    }
                    else if(atual.equals("-x")) {
                        atual = "-z";
                    }
                }
                else if(s.equals("-z")) {
                    if(atual.equals("-z")) {
                        atual = "-x";
                    }
                    else if(atual.equals("+z")) {
                        atual = "+x";
                    }
                    else if(atual.equals("+x") || atual.equals("No")) {
                        atual = "-z";
                    }
                    else if(atual.equals("-x")) {
                        atual = "+z";
                    }
                }
            }
            System.out.println(atual);
            n = input.nextInt();
            input.nextLine();
        }
    } 
}
