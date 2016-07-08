/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.Jogo;
import java.util.Random;

/**
 *
 * @author IzabelyFurtado
 * Fase 2: Carregar Merchant Bag
    Coloque as cartas que pretende levar ao mercado na bolsa de comerciante.
    - Colocar a partir de um a cinco produtos.
   * 
   Fase 3: Declaração
    Declare ao Sheriff quais bens você está entregando ao mercado[já com propina ou nao].
        - Apenas Bens legais pode ser declarado.
        - Apenas um tipo de bem pode ser declarado.
        - Você deve declarar o número exato de mercadorias na bolsa.
 */
public class CarregaDeclara {
    Jogo jogo;
    Bag[] bags;
    public CarregaDeclara(Jogo jogo){
        Mercado faseMercado = new Mercado(jogo);
        this.jogo = faseMercado.jogo;
        //criando bags
        Bag bag;
        Random gerador = new Random();
        int resultado, resultado2;
        //em sentido horario
        for (int i = 0; i < this.jogo.Jogadores.length; i++){
            //faz a escolha e coloca no bag
            bag = new Bag(this.jogo.Jogadores[i], this.jogo.xerife);
            this.bags[i] = bag;
        }
    }
    
    
}
