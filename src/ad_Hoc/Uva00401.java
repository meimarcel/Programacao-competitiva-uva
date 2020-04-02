/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva00401 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String,String> reverso = new HashMap<>();
        List<String> valids = new ArrayList<>();
        List<String> isMirror = new ArrayList<>();
        reverso.put("E", "3");
        reverso.put("J", "L");
        reverso.put("L", "J");
        reverso.put("S", "2");
        reverso.put("Z", "5");
        reverso.put("5", "Z");
        reverso.put("2", "S");
        reverso.put("3", "E");
        valids.addAll(Arrays.asList("A","H","I","M","O","T","U","V","W","X","Y","1","8"));
        isMirror.addAll(Arrays.asList("A","H","I","M","O","T","U","V","W","X","Y","1","8","E","J","L","S","Z","2","3","5"));
        while(input.hasNextLine()) {
            List<String> palavra = Arrays.asList(input.nextLine().split(""));
            String aux = String.join("", palavra);
            boolean palindrome = true;
            boolean valid = true;
            int j = palavra.size() - 1;
            for(int i = 0; i <= palavra.size() / 2; i++) {
                if(!palavra.get(i).equals(palavra.get(j - i))) {
                     palindrome = false;
                     break;
                } else {
                    if(valids.indexOf(palavra.get(i)) == -1) {
                        valid = false;
                    }
                }
            }
            boolean hasMirror = false;
            boolean mirror = true;
            for(String key : reverso.keySet()) {
                if((palavra.indexOf(key)) != -1) {
                    if(key.equals("2") || key.equals("3") || key.equals("5") || key.equals("L")) {
                        Collections.replaceAll(palavra, key, reverso.get(key));
                    }
                    hasMirror = true;
                }
            }
            if(hasMirror) {
                if(palavra.size()%2 != 0 ) {
                    if(valids.indexOf(palavra.get(palavra.size() / 2)) == -1) {
                        mirror = false;
                    }
                }
                if(mirror) {
                    for(int i = 0; i <= palavra.size() / 2; i++) {
                        if(!palavra.get(i).equals(palavra.get(j - i)) || isMirror.indexOf(palavra.get(i)) == -1) {
                             mirror = false;
                             break;
                        }
                    }
                }
            }

            if((!palindrome && !hasMirror) || (!palindrome && hasMirror && !mirror)) {
                System.out.println(String.join("", aux)+" -- is not a palindrome.");
            }
            if((palindrome && hasMirror) || (palindrome && !hasMirror && !valid)) {
                System.out.println(String.join("", aux)+" -- is a regular palindrome.");
            }
            if(!palindrome && mirror && hasMirror) {
                System.out.println(String.join("", aux)+" -- is a mirrored string.");
            }
            if(palindrome && !hasMirror && valid) {
                System.out.println(String.join("", aux)+" -- is a mirrored palindrome.");
            }
            System.out.println();
        }
    }
    
}
