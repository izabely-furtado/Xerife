/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia;

import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.MercadoriaTotal;
import ifes.trabia.mercadoria.Tipo;
import java.util.List;

/**
 *
 * @author IzabelyFurtado
 */
public class Xerife {
    int ouro;
    //mercadorias arrecadadas
    MercadoriaTotal arrecadadas;
    
    Xerife(){
        this.ouro = 50;
        this.arrecadadas = new MercadoriaTotal(1);
    }
    
    public void recebe(int quant){
        this.ouro += quant;
    }
    
    public void paga(int penalidade){
        if (penalidade <= this.ouro){
            this.ouro -= penalidade;
        }
        else {
            this.ouro = 0;
        }
    }
    
    public void arrecada(Tipo identificador){
        this.arrecadadas.getMercadoria(identificador).quantCartas++;
    }

    
    public int pontuacao(){
        int total = this.ouro;
        Tipo[] vetTipo = {Tipo.maca, Tipo.queijo, Tipo.pao, Tipo.galinha, 
                          Tipo.pimenta, Tipo.hidroMel, Tipo.tecido, Tipo.besta,
                          Tipo.macaVerde, Tipo.macaDourada, Tipo.queijoGouda, 
                          Tipo.queijoAzul, Tipo.paoCenteio, Tipo.paoCenteioIntegral, 
                          Tipo.galoReal};
        Mercadoria merc;
        for (Tipo t : vetTipo){
            merc = this.arrecadadas.getMercadoria(t);
            total = merc.quantCartas*2*merc.getValor();
        }
        return total;
    }
    
    
}
