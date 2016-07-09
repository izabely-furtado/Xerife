/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.jogadores.Jogador;
import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.MercadoriaTotal;
import ifes.trabia.mercadoria.Tipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author IzabelyFurtado
    Fase 3: Declaração
    Declare ao Sheriff quais bens você está entregando ao mercado[já com propina ou nao].
        - Apenas Bens legais pode ser declarado.
        - Apenas um tipo de bem pode ser declarado.
        - Você deve declarar o número exato de mercadorias na bolsa.

 */
public class Declara {
    List<Mercadoria>[] entregue;
    List<Mercadoria>[] declarado;
    
    Declara(Jogador[] jogadores){
        this.entregue = new List[jogadores.length];
        this.declarado = new List[jogadores.length];
        for (int j = 0; j < jogadores.length; j++) {
            this.entregue[j] = Carrega.carregaBag(jogadores[j]);
            switch (jogadores[j].tipo){
                case Verdadeiro:
                    this.declarado[j] = Declara.dizVDD(jogadores[j], this.entregue[j]);
                case Contrabandista:
                    this.declarado[j] = Declara.dizMeiaVDD(jogadores[j], this.entregue[j]);
                case Aleatorio:
                    this.declarado[j] = Declara.dizMeiaVDD(jogadores[j], this.entregue[j]);
            }
        }
    }
        
    //retorna afirmações validas aleatoriamente
    public static List<Mercadoria> validas(int quantidade){
        List<Mercadoria> retorno = new ArrayList();
        Random gerador = new Random();
        Tipo[] vetTipo = {Tipo.maca, Tipo.queijo, Tipo.pao, Tipo.galinha};
        MercadoriaTotal mT = new MercadoriaTotal(1);
        for (int i = 0; i < quantidade; i++){
            retorno.add(mT.getMercadoria(vetTipo[gerador.nextInt(3)]));
        }
        return retorno;
    }
            
    //diz a verdade sobre mercadorias 
    //a vdd é só um ponto de vista
    public static List<Mercadoria> dizVDD(Jogador jogador, List<Mercadoria> entregue){
        List<Mercadoria> retorno = new ArrayList();
        retorno.addAll(Carrega.legais(jogador));
        //Nao pode dizer a verdade tendo somente contrabando
        //entao diz meia vdd... mente
        if (entregue.size()-retorno.size()>0){
            retorno.addAll(Declara.validas(entregue.size()-retorno.size()));
        }
        return retorno;
    }
    
    //diz a verdade sobre mercadorias legais, 
        //se houverem ilegais, se mente
    public static List<Mercadoria> dizMeiaVDD(Jogador jogador, List<Mercadoria> entregue){
        List<Mercadoria> retorno = new ArrayList();
        retorno.addAll(Carrega.legais(jogador));
        retorno.addAll(Declara.validas(entregue.size()-retorno.size()));
        return retorno;
    }
    
}
