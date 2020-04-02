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
public class SegmentTree2 {
    public int vector[];
    public int st[];
    
    public SegmentTree2(int vector[]) {
        this.vector = vector;
        int x = (int) Math.ceil(Math.log(vector.length) / Math.log(2));
        int size = 2 * 1 << x;
        st = new int[size];
        build(0, 0, vector.length - 1);
    }
    
    public int build(int p, int L, int R) {
        if(L == R) {
            return st[p] = vector[L];
        }
        
        int meio = (L + R) / 2;
        return st[p] = build((2 * p) + 1, L, meio) + build((p * 2) + 2, meio + 1, R);  
    }
    
    public void update(int p, int L, int R, int i, int n) {
        if(i < L || i > R) {
            return;
        }
        st[p] += n;
        if(L != R) {
            int meio = (L + R) / 2;
            update((2 * p) + 1, L, meio, i, n);
            update((2 * p) + 2, meio + 1, R, i, n);
        }
    }
    
    public void update(int i, int n) {
        update(0, 0, vector.length - 1, i, n);
    }
    
    public int RSQ(int p, int L, int R, int i, int j) {
        if(j < L || i > R) {
            return 0;
        }
        if(L >= i && R <= j) {
            return st[p];
        }
        int meio = (R + L) / 2;
        return RSQ((2 * p) + 1, L, meio, i, j) + RSQ((2 * p) + 2, meio + 1, R, i, j);
    }
    
    public int RSQ(int i, int j) {
        return RSQ(0, 0, vector.length - 1, i, j);
    }
    
    public static void main(String[] args) {
        int numbers[] = {1, 35, 7, 9, 11};
        SegmentTree2 S = new SegmentTree2(numbers);
        System.out.println(S.RSQ(0, 1));
        S.update(0, 1);
        System.out.print(S.RSQ(3, 4));
    }
}
