/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author meimarcel
 */
public class FenwickTree {
    
    public int ft[];
    
    public FenwickTree(int n) {
        ft = new int[n + 1];
    }
    
    public int LSOne(int n) {
        return (n & -n);
    }
    
    public int RSQ(int i) {
        int sum = 0;
        for(; i > 0; i -= LSOne(i)) sum += ft[i];
        return sum; 
    }
    
    public int RSQ(int i, int j) {
        return RSQ(j) - ((i == 1)? 0 : RSQ(i-1));
    }
    
    public void adjust(int i, int n) {
        for(; i < ft.length; i += LSOne(i)) ft[i] += n;
        
    }
    
    public static void main(String[] args) {
        //Exemplo de soma de frequencias em um range de 1..10
        int frequency[] = {2,4,5,5,6,6,6,7,7,8,9};
        FenwickTree F1 = new FenwickTree(10);
        for(int i = 0; i < frequency.length; i++) {
            F1.adjust(frequency[i], 1);
        }
        
        System.out.println(F1.RSQ(6));
        System.out.println(F1.RSQ(3, 6));
        
        //Exemplo de soma dos numeros nas posicoes do array
        int numbers[] = {1,3,4,6,10,5};
        FenwickTree F2 = new FenwickTree(6);
        for(int i = 0; i < numbers.length; i++) {
            F2.adjust(i+1, numbers[i]);

        }   
        System.out.println(F2.RSQ(3));
        System.out.println(F2.RSQ(5,6));
        
    }
    
}
