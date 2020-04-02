/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad_Hoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author meimarcel
 */
public class Uva00462 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()) {
            String cartas[] = input.nextLine().split(" ");
            int pontos = 0;
            Map<String,Integer> naipes = new HashMap<>();
            Map<String,Boolean> stoped = new HashMap<>();
            List<String> king = new ArrayList<>();
            List<String> queen = new ArrayList<>();
            List<String> jack = new ArrayList<>();
            naipes.put("S",0);
            naipes.put("H",0);
            naipes.put("D",0);
            naipes.put("C",0);
            stoped.put("S",false);
            stoped.put("H",false);
            stoped.put("D",false);
            stoped.put("C",false);
            
            for(String carta : cartas) {
                String valor = carta.split("")[0];
                String naipe = carta.split("")[1];
                if(valor.equals("A")) {
                    stoped.replace(naipe, true);
                    pontos += 4;
                }
                else if(valor.equals("K")) {
                    pontos += 3;
                    king.add(naipe);
                }
                else if(valor.equals("Q")) {
                    pontos += 2;
                    queen.add(naipe);
                }
                else if(valor.equals("J")) {
                    pontos += 1;
                    jack.add(naipe);
                }
                
                if(naipe.equals("S")) {
                    naipes.replace("S", naipes.get("S") + 1);
                }
                else if(naipe.equals("H")) {
                    naipes.replace("H", naipes.get("H") + 1);
                }
                else if(naipe.equals("D")) {
                    naipes.replace("D", naipes.get("D") + 1);
                }
                else if(naipe.equals("C")) {
                    naipes.replace("C", naipes.get("C") + 1);
                }
            }
            
            int pontosAux = 0;
            for(String key : naipes.keySet()) {
                if(naipes.get(key) == 2) {
                    pontosAux++;
                }
                else if(naipes.get(key) == 1) {
                    pontosAux += 2;
                }
                else if(naipes.get(key) == 0) {
                    pontosAux += 2;
                }
                if(king.indexOf(key) != -1) {
                    if(naipes.get(key) == 1) {
                        pontos--;
                    }
                    if(naipes.get(key) > 1) {
                        stoped.replace(key, true);
                    }
                }
                if(queen.indexOf(key) != -1) {
                    if(naipes.get(key) <= 2) {
                        pontos--;
                    }
                    if(naipes.get(key) > 2) {
                        stoped.replace(key, true);
                    }
                }
                if(jack.indexOf(key) != -1) {
                    if(naipes.get(key) <= 3) {
                        pontos--;
                    }
                }
            }
            
            if(pontos + pontosAux < 14) {
                System.out.println("PASS");
            } else {
                if(pontos >= 16) {       
                    boolean trump = true;
                    for(boolean b : stoped.values()) {
                        if(!b) {
                            trump = false;
                        }
                    }
                    if(trump) {
                        System.out.println("BID NO-TRUMP");
                    } else {
                        String naipe = "";
                        int qtd = 0;
                        for(String key : naipes.keySet()) {
                            if(naipes.get(key) > qtd) {
                                naipe = key;
                                qtd = naipes.get(key);
                            }
                             else if(naipes.get(key) == qtd) {
                                if(key.equals("S")) {
                                    naipe = key;
                                    qtd = naipes.get(key);
                                }
                                else if(key.equals("H") && !naipe.equals("S") ) {
                                    naipe = key;
                                    qtd = naipes.get(key);
                                }
                                else if(key.equals("D") && naipe.equals("C") ) {
                                    naipe = key;
                                    qtd = naipes.get(key);
                                }
                            }
                        }
                        System.out.println("BID "+naipe);
                    }
                } else {
                    String naipe = "";
                    int qtd = 0;
                    for(String key : naipes.keySet()) {
                        if(naipes.get(key) > qtd) {
                            naipe = key;
                            qtd = naipes.get(key);
                        }
                        else if(naipes.get(key) == qtd) {
                            if(key.equals("S")) {
                                naipe = key;
                                qtd = naipes.get(key);
                            }
                            else if(key.equals("H") && !naipe.equals("S") ) {
                                naipe = key;
                                qtd = naipes.get(key);
                            }
                            else if(key.equals("D") && naipe.equals("C") ) {
                                naipe = key;
                                qtd = naipes.get(key);
                            }
                        }
                    }
                    System.out.println("BID "+naipe);
                }
                
            }         
        }
    }
    
}
