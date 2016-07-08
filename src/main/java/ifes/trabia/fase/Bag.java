/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.Jogador;
import ifes.trabia.mercadoria.Mercadoria;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IzabelyFurtado
 */
public class Bag {
    Jogador jogador;
    List<Mercadoria> dizQueEntregou;
    List<Mercadoria> entregou;
    
    Bag(Jogador joador, List<Mercadoria> dizQue, List<Mercadoria> entregou){
        this.jogador = jogador;
        this.dizQueEntregou = dizQue;
        this.entregou = entregou;
    }
    
    public List<Mercadoria> diferenca(){
        List<Mercadoria> dif = new ArrayList();
        
        if (this.dizQueEntregou.containsAll(entregou)){
            return null;
        }
        else{
            for (Mercadoria m: this.entregou){
                if (this.dizQueEntregou.contains(m)){
                    dif.add(m);
                }
            }
            return dif;
        }
    }
    
    
}

