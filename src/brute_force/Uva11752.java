/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brute_force;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva11752 {
    
    public static void next_permutation(int array[], int L, int R, int a, int b, int c) {
        int vector[] = array;
        int cont = 0;
        if(L == R) {
            System.out.println(Arrays.toString(vector));
        } else {
            for(int i = L; i <= R; i++) {
                swap(vector, L, i);
                next_permutation(array, L + 1, R, a, b, c);
                swap(vector, L, i);
            }   
        }

    }
    
    public static void swap(int array[], int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int v[] = {1,2,3};
        next_permutation(v,0,2,4,5,7);
    }
    
}
