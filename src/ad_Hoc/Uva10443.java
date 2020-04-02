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
public class Uva10443 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        while(n > 0) {
            String e[] = input.nextLine().split(" ");
            int m = Integer.parseInt(e[0]);
            int z = Integer.parseInt(e[1]);
            String atual[][] = new String[m][z];
            String aux[][] = new String[m][z];
            for(int i = 0; i < m; i++) {
                atual[i] = input.nextLine().split("");
            }
            for(int i = 0; i < Integer.parseInt(e[2]); i++) {
                for(int x = 0; x < m; x++) {
                    for(int y = 0; y < z; y++) {
                        aux[x][y] = atual[x][y];
                        if(x+1 < m) {
                            if(atual[x][y].equals("R")) {
                                if(atual[x+1][y].equals("S")) {
                                    aux[x+1][y] = "R";
                                }
                                else if(atual[x+1][y].equals("P")) {
                                    aux[x][y] = "P";
                                }
                            }
                            else if(atual[x][y].equals("S")) {
                                if(atual[x+1][y].equals("P")) {
                                    aux[x+1][y] = "S";
                                }
                                else if(atual[x+1][y].equals("R")) {
                                    aux[x][y] = "R";
                                }
                            }
                            else if(atual[x][y].equals("P")) {
                                if(atual[x+1][y].equals("R")) {
                                    aux[x+1][y] = "P";
                                }
                                else if(atual[x+1][y].equals("S")) {
                                    aux[x][y] = "S";
                                }
                            }
                        }
                        if(x-1 >= 0) {
                            if(atual[x][y].equals("R")) {
                                if(atual[x-1][y].equals("S")) {
                                    aux[x-1][y] = "R";
                                }
                                else if(atual[x-1][y].equals("P")) {
                                    aux[x][y] = "P";
                                }
                            }
                            else if(atual[x][y].equals("S")) {
                                if(atual[x-1][y].equals("P")) {
                                    aux[x-1][y] = "S";
                                }
                                else if(atual[x-1][y].equals("R")) {
                                    aux[x][y] = "R";
                                }
                            }
                            else if(atual[x][y].equals("P")) {
                                if(atual[x-1][y].equals("R")) {
                                    aux[x-1][y] = "P";
                                }
                                else if(atual[x-1][y].equals("S")) {
                                    aux[x][y] = "S";
                                }
                            }
                        }
                        if((y+1) < z) {
                            if(atual[x][y].equals("R")) {
                                if(atual[x][y+1].equals("S")) {
                                    aux[x][y+1] = "R";
                                }
                                else if(atual[x][y+1].equals("P")) {
                                    aux[x][y] = "P";
                                }
                            }
                            else if(atual[x][y].equals("S")) {
                                if(atual[x][y+1].equals("P")) {
                                    aux[x][y+1] = "S";
                                }
                                else if(atual[x][y+1].equals("R")) {
                                    aux[x][y] = "R";
                                }
                            }
                            else if(atual[x][y].equals("P")) {
                                if(atual[x][y+1].equals("R")) {
                                    aux[x][y+1] = "P";
                                }
                                else if(atual[x][y+1].equals("S")) {
                                    aux[x][y] = "S";
                                }
                            }
                        }
                        if(y-1 >= 0) {
                            if(atual[x][y].equals("R")) {
                                if(atual[x][y-1].equals("S")) {
                                    aux[x][y-1] = "R";
                                }
                                else if(atual[x][y-1].equals("P")) {
                                    aux[x][y] = "P";
                                }
                            }
                            else if(atual[x][y].equals("S")) {
                                if(atual[x][y-1].equals("P")) {
                                    aux[x][y-1] = "S";
                                }
                                else if(atual[x][y-1].equals("R")) {
                                    aux[x][y] = "R";
                                }
                            }
                            else if(atual[x][y].equals("P")) {
                                if(atual[x][y-1].equals("R")) {
                                    aux[x][y-1] = "P";
                                }
                                else if(atual[x][y-1].equals("S")) {
                                    aux[x][y] = "S";
                                }
                            }
                        }
                    }
                }
                atual = Arrays.stream(aux).map(r -> r.clone()).toArray(String[][]::new);
            }
            for(int i = 0; i < m; i++) {
                System.out.println(String.join("", atual[i]));
            }
            if(n != 1) {
                System.out.println();
            }
            n--;
        }           
    } 
}
