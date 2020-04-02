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
public class Uva10189 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cont = 1;
        while(input.hasNextLine()) {
            String dim[] = input.nextLine().split(" ");
            int n = Integer.parseInt(dim[0]);
            int m = Integer.parseInt(dim[1]);
            if(dim[0].equals("0") && dim[1].equals("0")) {
                break;
            }
            String mina[][] = new String[n][];
            for(int i = 0; i < n; i++) {
                mina[i] = input.nextLine().split("");
            }
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++){
                    int num = 0;
                    if(!mina[i][j].equals("*")) {
                        if(i+1 < n) {if(mina[i+1][j].equals("*")) num++;}
                        if(i-1 >= 0) {if(mina[i-1][j].equals("*")) num++;}
                        if(j+1 < m) {if(mina[i][j+1].equals("*")) num++;}
                        if(j-1 >= 0) {if(mina[i][j-1].equals("*")) num++;}
                        
                        if(i+1 < n && j+1 < m) {if(mina[i+1][j+1].equals("*")) num++;}
                        if(i-1 >= 0 && j-1 >= 0) {if(mina[i-1][j-1].equals("*")) num++;}
                        if(i+1 < n && j-1 >= 0) {if(mina[i+1][j-1].equals("*")) num++;}
                        if(i-1 >= 0 && j+1 < m) {if(mina[i-1][j+1].equals("*")) num++;}
                        mina[i][j] = String.valueOf(num);
                    }
                }
            }
            if(cont != 1) {
                System.out.println();
            }
            System.out.println("Field #"+(cont++)+":");
            for(int i = 0; i < n; i++) {
                System.out.println(String.join("", mina[i]));
            }
            
        }
        
    }
    
}
