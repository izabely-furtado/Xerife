/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.jogadores.Jogador;
import ifes.trabia.Jogo;

/**
 *
 * @author IzabelyFurtado
 */
public class Fim {
    Jogo jogo;
    /*
    Fase 5: Fim da Rodada
- Todos os jogadores devem comprar da pilha principal[a escondida] ate ter seis cartas.
*/
    Fim(Jogo jogo){
        this.jogo = new Inspecao(jogo).cartasDeclaras.jogo;
        for (Jogador j:this.jogo.Jogadores){
            if (j.emMaos==null){
                //j.emMaos
            }
        }
    }
}
