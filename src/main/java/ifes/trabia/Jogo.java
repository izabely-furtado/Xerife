/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia;

import ifes.trabia.jogadores.Jogador;
import ifes.trabia.mercadoria.Embaralha;
import ifes.trabia.mercadoria.MercadoriaTotal;

/**
 *
 * @author IzabelyFurtado
 * Toda vez que o jogo começar, 
 *      -  deve ser retirado aleatoriamente 10 cartas do jogo 
 *          - sem revelar pra ninguém quais cartas foram removidas. 
 * assim remove-se a ideia de contar cartas.
 */
public class Jogo {
    public int quantJogadores;
    public Jogador[] Jogadores;
    public Embaralha baralho;
    public Xerife xerife;
    
    Jogo(int quantJogadores, Jogador[] jogadores){
        this.quantJogadores = quantJogadores;
        this.Jogadores = jogadores;
        this.baralho = new Embaralha(this.quantJogadores, 10);
        this.xerife = new Xerife();
    }
    
    
}
