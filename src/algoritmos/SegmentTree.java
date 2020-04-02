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
public class SegmentTree {
    
    public int st[]; 
    public int vector[];
    
    public SegmentTree(int vector[]) {
        this.vector = vector;
        int x = (int) Math.ceil(Math.log(vector.length) / Math.log(2));
        int size = 2 * (1 << x) - 1;
        st = new int[size];
        build(0, 0, vector.length - 1);
    }
    
    public int build(int p, int L, int R) {
        if(L == R) {
            return st[p] = L;
        }
        int meio = (L + R) / 2;
        int p1 = build((p*2) + 1, L, meio);
        int p2 = build((p*2) + 2, meio+1, R);
        return st[p] = (vector[p1] <= vector[p2])? p1 : p2;
    }
    
    public int RMQ(int p, int L, int R, int i, int j) {
        if(L > j || R < i) {
             return -1;
        }
        if(L >= i && R <= j) {
            return st[p];
        }
        int meio = (L + R) / 2;
        int p1 = RMQ((p*2) + 1, L, meio, i ,j);
        int p2 = RMQ((p*2) + 2, meio + 1, R, i, j);
        if(p1 == -1) return p2;
        if(p2 == -1) return p1;
        return (vector[p1] <= vector[p2])? p1 : p2;
    }
    
    public int RMQ(int i, int j) {
        return RMQ(0, 0 , vector.length, i ,j);
    }
    
    public int update(int p, int L, int R, int i, int n) {
        if(L > i || R < i) {
            return st[p];
        }
        if(L == i && R == i) {
            this.vector[i] = n;
        }
        if(L == R) {
            return st[p];
        }
        int meio = (L + R) / 2;
        int p1 = update((p*2) + 1, L, meio, i , n);
        int p2 = update((p*2) + 2, meio + 1, R, i , n);
        return st[p] = (vector[p1] <= vector[p2])? p1 : p2; 
    }
    
    public int update(int i, int n) {
        return update(0, 0 , vector.length, i ,n);
    }
    
    public static void main(String[] args) {
        int vector[] = {18,17,13,19,15,11,20};
        SegmentTree S = new SegmentTree(vector);
        System.out.println(S.RMQ(1, 4));
        S.update(3, 3);     
        System.out.println(S.RMQ(1, 4));
    }
}
