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
public class Uva10284 {
    public static final int[] cx = {1,1,-1,-1,2,2,-2,-2};
    public static final int[] cy = {2,-2,2,-2,1,-1,1,-1};
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String tabuleiro[][] = new String[9][9];
            for(int i  = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    tabuleiro[i][j] = "0";
                }
            }
            String entrada[] = input.nextLine().split("/");
            int x = 1;
            for(String s : entrada) {
                int j = 1;
                String p[] = s.split("");
                for(String k : p) {
                    if(k.equals("R") || k.equals("r") || k.equals("n") || k.equals("N") ||
                            k.equals("b") || k.equals("B") || k.equals("q") || k.equals("Q") ||
                            k.equals("k") || k.equals("K") || k.equals("p") || k.equals("P")) {
                        
                        tabuleiro[x][j] = k;                  
                    } else {
                        j += Integer.parseInt(k) - 1;
                    }
                    j++;
                }
                x++;
            }
            x = 1;
            for(String s : entrada) {
                int j = 1;
                String p[] = s.split("");
                for(String k : p) {
                    if(k.equals("R") || k.equals("r")) {
                        boolean cond1 = true;
                        boolean cond2 = true;
                        boolean cond3 = true;
                        boolean cond4 = true;
                        for(int i  = 1; i < 9; i++) {
                            if(x+i <= 8) {
                                if((tabuleiro[x+i][j].equals("0") || tabuleiro[x+i][j].equals("1")) && cond1) {
                                    tabuleiro[x+i][j] = "1";
                                } else {
                                    cond1 = false;
                                }   
                            }
                            if(x-i >= 1) {
                                if((tabuleiro[x-i][j].equals("0") || tabuleiro[x-i][j].equals("1")) && cond2) {
                                    tabuleiro[x-i][j] = "1";
                                } else {
                                    cond2 = false;
                                }   
                            }
                            if(j+i <= 8) {
                                if((tabuleiro[x][j+i].equals("0") || tabuleiro[x][j+i].equals("1")) && cond3) {
                                    tabuleiro[x][j+i] = "1";
                                } else {
                                    cond3 = false;
                                }
                            }
                            if(j-i >= 1) {
                                if((tabuleiro[x][j-i].equals("0") || tabuleiro[x][j-i].equals("1")) && cond4) {
                                    tabuleiro[x][j-i] = "1";
                                } else {
                                    cond4 = false;
                                }
                            }
                        }
                    }
                    else if(k.equals("n") || k.equals("N")) {
                        for(int i  = 1; i < 9; i++) {
                            if(x+cx[i-1] >= 1 && x+cx[i-1] <= 8 && j+cy[i-1] >= 1 && j+cy[i-1] <= 8) {
                                if(tabuleiro[x+cx[i-1]][j+cy[i-1]].equals("0") || tabuleiro[x+cx[i-1]][j+cy[i-1]].equals("1")) {
                                    tabuleiro[x+cx[i-1]][j+cy[i-1]] = "1";
                                }
                            }

                        }
                    }
                    else if(k.equals("b") || k.equals("B")) {
                        boolean cond1 = true;
                        boolean cond2 = true;
                        boolean cond3 = true;
                        boolean cond4 = true;
                        for(int i  = 1; i < 9; i++) {
                            if(x+i <= 8 && j+i <= 8) {
                                if((tabuleiro[x+i][j+i].equals("0") || tabuleiro[x+i][j+i].equals("1")) && cond1) {
                                    tabuleiro[x+i][j+i] = "1";
                                } else {
                                    cond1 = false;
                                }
                            }
                            if(x-i >= 1 && j-i >= 1) {
                                if((tabuleiro[x-i][j-i].equals("0") || tabuleiro[x-i][j-i].equals("1")) && cond2) {
                                    tabuleiro[x-i][j-i] = "1";
                                } else {
                                    cond2 = false;
                                }
                            }
                            if(x+i <= 8 && j-i >= 1) {
                                if((tabuleiro[x+i][j-i].equals("0") || tabuleiro[x+i][j-i].equals("1")) && cond3) {
                                    tabuleiro[x+i][j-i] = "1";
                                } else {
                                    cond3 = false;
                                }
                            }
                            if(x-i >= 1 && j+i <= 8) {
                                if((tabuleiro[x-i][j+i].equals("0") || tabuleiro[x-i][j+i].equals("1")) && cond4) {
                                    tabuleiro[x-i][j+i] = "1";
                                } else {
                                    cond4 = false;
                                }
                            }
                        }
                    }
                    else if(k.equals("q") || k.equals("Q")) {
                        boolean cond1 = true;
                        boolean cond2 = true;
                        boolean cond3 = true;
                        boolean cond4 = true;
                        boolean cond5 = true;
                        boolean cond6 = true;
                        boolean cond7 = true;
                        boolean cond8 = true;
                        for(int i  = 1; i < 9; i++) {
                            if(x+i <= 8 && j+i <= 8) {
                                if((tabuleiro[x+i][j+i].equals("0") || tabuleiro[x+i][j+i].equals("1")) && cond1) {
                                    tabuleiro[x+i][j+i] = "1";
                                } else {
                                    cond1 = false;
                                }
                            }
                            if(x-i >= 1 && j-i >= 1) {
                                if((tabuleiro[x-i][j-i].equals("0") || tabuleiro[x-i][j-i].equals("1")) && cond2) {
                                    tabuleiro[x-i][j-i] = "1";
                                } else {
                                    cond2 = false;
                                }
                            }
                            if(x+i <= 8 && j-i >= 1) {
                                if((tabuleiro[x+i][j-i].equals("0") || tabuleiro[x+i][j-i].equals("1")) && cond3) {
                                    tabuleiro[x+i][j-i] = "1";
                                } else {
                                    cond3 = false;
                                }
                            }
                            if(x-i >= 1 && j+i <= 8) {
                                if((tabuleiro[x-i][j+i].equals("0") || tabuleiro[x-i][j+i].equals("1")) && cond4) {
                                    tabuleiro[x-i][j+i] = "1";
                                } else {
                                    cond4 = false;
                                }
                            }
                            if(x+i <= 8) {
                                if((tabuleiro[x+i][j].equals("0") || tabuleiro[x+i][j].equals("1")) && cond5) {
                                    tabuleiro[x+i][j] = "1";
                                } else {
                                    cond5 = false;
                                }   
                            }
                            if(x-i >= 1) {
                                if((tabuleiro[x-i][j].equals("0") || tabuleiro[x-i][j].equals("1")) && cond6) {
                                    tabuleiro[x-i][j] = "1";
                                } else {
                                    cond6 = false;
                                }   
                            }
                            if(j+i <= 8) {
                                if((tabuleiro[x][j+i].equals("0") || tabuleiro[x][j+i].equals("1")) && cond7) {
                                    tabuleiro[x][j+i] = "1";
                                } else {
                                    cond7 = false;
                                }
                            }
                            if(j-i >= 1) {
                                if((tabuleiro[x][j-i].equals("0") || tabuleiro[x][j-i].equals("1")) && cond8) {
                                    tabuleiro[x][j-i] = "1";
                                } else {
                                    cond8 = false;
                                }
                            }
                        }
                    }
                    else if(k.equals("k") || k.equals("K")) {
                        if(x+1 <= 8 && (tabuleiro[x+1][j].equals("0") || tabuleiro[x+1][j].equals("1"))) tabuleiro[x+1][j] = "1";
                        if(x-1 >= 1 && (tabuleiro[x-1][j].equals("0") || tabuleiro[x-1][j].equals("1"))) tabuleiro[x-1][j] = "1";;
                        if(x+1 <= 8 && j+1 <= 8 && (tabuleiro[x+1][j+1].equals("0") || tabuleiro[x+1][j+1].equals("1"))) tabuleiro[x+1][j+1] = "1";
                        if(x-1 >= 1 && j-1 >= 1 && (tabuleiro[x-1][j-1].equals("0") || tabuleiro[x-1][j-1].equals("1"))) tabuleiro[x-1][j-1] = "1";
                        if(x+1 <= 8 && j-1 >= 1 && (tabuleiro[x+1][j-1].equals("0") || tabuleiro[x+1][j-1].equals("1"))) tabuleiro[x+1][j-1] = "1";
                        if(x-1 >= 1 && j+1 <= 8 && (tabuleiro[x-1][j+1].equals("0") || tabuleiro[x-1][j+1].equals("1"))) tabuleiro[x-1][j+1] = "1";
                        if(j-1 >= 1 && (tabuleiro[x][j-1].equals("0") || tabuleiro[x][j-1].equals("1"))) tabuleiro[x][j-1] = "1";
                        if(j+1 <= 8 && (tabuleiro[x][j+1].equals("0") || tabuleiro[x][j+1].equals("1"))) tabuleiro[x][j+1] = "1";
                    }
                    else if(k.equals("p")) {
                        if(x+1 <= 8 && j+1 <= 8 && (tabuleiro[x+1][j+1].equals("0") || tabuleiro[x+1][j+1].equals("1"))) tabuleiro[x+1][j+1] = "1";
                        if(x+1 <= 8 && j-1 >= 1 && (tabuleiro[x+1][j-1].equals("0") || tabuleiro[x+1][j-1].equals("1"))) tabuleiro[x+1][j-1] = "1";
                    }
                    else if(k.equals("P")) {
                        if(x-1 >= 1 && j+1 <= 8 && (tabuleiro[x-1][j+1].equals("0") || tabuleiro[x-1][j+1].equals("1"))) tabuleiro[x-1][j+1] = "1";
                        if(x-1 >= 1 && j-1 >= 1 && (tabuleiro[x-1][j-1].equals("0") || tabuleiro[x-1][j-1].equals("1"))) tabuleiro[x-1][j-1] = "1";
                    } else {
                        j += Integer.parseInt(k) - 1;
                    }
                    j++;
                }
                x++;
            }
            int cont = 0;
            for(int a = 1; a < 9; a++) {
                for(int b = 1; b < 9; b++) {
                    if(tabuleiro[a][b].equals("0")) cont++;
                }
            }
            System.out.println(cont);
        }
    }
}
