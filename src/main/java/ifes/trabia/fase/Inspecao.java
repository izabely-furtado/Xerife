/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.Jogador;
import ifes.trabia.Jogo;
import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.MercadoriaTotal;
import java.util.Random;

/**
 *
 * @author IzabelyFurtado
 * Fase 4: Inspeção
    O Sheriff pode optar por inspecionar os sacos mercantes.
    - Os jogadores podem oferecer subornos para evitar a inspeção.                AQUI
    *   Na verdade, o Sheriff pode ameaçar uma inspeção para adquirir um suborno. AQUI
            - Subornos podem incluir 
            *   ouro, 
            *   produtos no saco, 
            *   Cartas na mão não pode ser usado em subornos.
    - Sheriff escolhe permitir qual jogador passa ou inspecionar o saco.          AQUI
    - Se o jogador está autorizado a passar, 
    *   ele adquire todos os bens de sua posição de comerciante. 
    *   bens normais vão pra suas áreas apropriadas. 
    *   Contrabandos vao viradas para baixo[o xerife nao sabe qual contrabando passou].
    - Se um jogador é inspecionado, e teve exatamente o que foi declarado, 
    *   o Sheriff paga jogador ouro igual a pena em todos os bens legais no saco.
    - Se um jogador é inspecionado, e não tem exatamente o que foi declarado, 
    *   ele mantém todos os bens verdadeiramente declarados, 
    *   e descarta todos os bens não-verdadeiras. 
    *   Ele também paga o Sheriff a quantidade penalidade sobre os produtos descartados 
    *       [e o xerife pega pra ele o q seria descartado].
 */
public class Inspecao {
    CarregaDeclara cartasDeclaras;
    Inspecao(Jogo jogo){
        MercadoriaTotal mt = new MercadoriaTotal(jogo.quantJogadores);
        Random gerador = new Random();
        int quantCartaJogo = 0;
        this.cartasDeclaras = new CarregaDeclara(jogo);
        int quantProvavel = 0;
        for (int bag = 0; bag < this.cartasDeclaras.bags.length; bag++){
            //verificar cartas pegas do descarte
            quantProvavel += this.cartasDeclaras.bags[bag].jogador.emMaosVizualizada.size()/this.cartasDeclaras.bags[bag].entregou.size();
            quantProvavel -= Bag.diferenca(this.cartasDeclaras.bags[bag].entregou, this.cartasDeclaras.bags[bag].jogador.emMaosVizualizada).size()/this.cartasDeclaras.bags[bag].jogador.emMaosVizualizada.size();
            //verificar probabilidade de cada carta aparecer
            //considerando cartas cm xerife e jogadores
            //em relação ao total
            for (Mercadoria m: this.cartasDeclaras.bags[bag].dizQueEntregou){
                for (Jogador j : this.cartasDeclaras.jogo.Jogadores){
                    quantCartaJogo += j.arrecadadas.getMercadoria(m.id).quantCartas;
                }
                quantCartaJogo += this.cartasDeclaras.jogo.xerife.arrecadadas.getMercadoria(m.id).quantCartas;
                quantProvavel += (mt.getMercadoria(m.id).quantCartas - quantCartaJogo)/mt.total;
            }
            //só considerando 20% de voto de confiança diante do historico
            quantProvavel += this.cartasDeclaras.bags[bag].jogador.confianca/5;
            if (quantProvavel < 40){
                this.cartasDeclaras.bags[bag].seXerifeNConfiou();
            }
            else if (quantProvavel > 60) {
                this.cartasDeclaras.bags[bag].seXerifeConfiou();
            }
            else {
                //xerife indica que vai verificar o pacote
                //jogador oferece subordo ou nao
                //colocando como exemplo aleatorio somente subordo por ouro
                int ouroOferecido = gerador.nextInt(this.cartasDeclaras.bags[bag].jogador.ouro);
                if (quantProvavel >=40 && quantProvavel < 50 && ouroOferecido > 2*this.cartasDeclaras.bags[bag].entregou.size()){
                    this.cartasDeclaras.bags[bag].seXerifeSubornado(ouroOferecido);
                }
                if (quantProvavel >=50 && quantProvavel <= 60 && ouroOferecido > 1*this.cartasDeclaras.bags[bag].entregou.size()){
                    this.cartasDeclaras.bags[bag].seXerifeSubornado(ouroOferecido);
                }
                else {
                    this.cartasDeclaras.bags[bag].seXerifeNConfiou();
                }
            }
            this.cartasDeclaras.jogo.Jogadores[bag] = this.cartasDeclaras.bags[bag].jogador;
            this.cartasDeclaras.jogo.xerife = this.cartasDeclaras.bags[bag].xerife;
        }
    }    
        
     
        
        
    
    
    
}
