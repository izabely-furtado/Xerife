/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.mercadoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author IzabelyFurtado
 * EMBARALHANDO AS CARTAS/MERCADORIAS
 */
public class Embaralha {
    List<Mercadoria> baralho;
    List<Mercadoria> descarte1;
    List<Mercadoria> descarte2;
    
    
    public Embaralha(int quantJogadores){
        //construindo baralho
        this.baralho = new ArrayList();
        Tipo[] vetTipo = {Tipo.maca, Tipo.queijo, Tipo.pao, Tipo.galinha, 
                          Tipo.pimenta, Tipo.hidroMel, Tipo.tecido, Tipo.besta,
                          Tipo.macaVerde, Tipo.macaDourada, Tipo.queijoGouda, 
                          Tipo.queijoAzul, Tipo.paoCenteio, Tipo.paoCenteioIntegral, 
                          Tipo.galoReal};
        MercadoriaTotal total = new MercadoriaTotal(quantJogadores);
        Mercadoria merc;
        for (Tipo t : vetTipo){
            while (total.getMercadoria(t).quantCartas>0){
                merc = total.getMercadoria(t);
                merc.unaCarta();
                this.baralho.add(merc);
                total.getMercadoria(t).quantCartas--;
            }
        }
        //embaralhando
        Collections.shuffle(this.baralho); 
        
        //descartando 5 cartas
        this.descarte1 = new ArrayList();
        this.descarte2 = new ArrayList();
        for (int i = 0; i < 5; i++) {
            merc = this.baralho.get(0);
            this.baralho.remove(merc);
            if (i <= 2) {
                this.descarte1.add(merc);
            }
            else {
                this.descarte2.add(merc);
            }
    
        }
    }
    
    public Embaralha(int quantJogadores, int quantCartasRemover){
        Embaralha baralhoSem = new Embaralha(quantJogadores);
        for (int i = 0; i < quantCartasRemover; i++) {
            baralhoSem.baralho.remove(i);
        }
        this.baralho = baralhoSem.baralho;
        this.descarte1 = baralhoSem.descarte1;
        this.descarte2 = baralhoSem.descarte2;
    }
    
    public Mercadoria getBaralho(){
        return this.baralho.remove(this.descarte1.size()-1);
    }
    
    public Mercadoria getDescarte1(){
        return this.descarte1.remove(this.descarte1.size()-1);
    }
    
    public Mercadoria getDescarte2(){
        return this.descarte2.remove(this.descarte1.size()-1);
    }
    
    //devolve aleatoriamente em um dos descartes
    public Tipo setDescarte(Mercadoria merc){
        Random gerador = new Random();
        boolean resultado = gerador.nextBoolean();
        if (resultado == true){
            this.descarte1.add(merc);
            return Tipo.descarte1;
        }
        else{
            this.descarte2.add(merc);
            return Tipo.descarte2;
        }
    }
    
}
