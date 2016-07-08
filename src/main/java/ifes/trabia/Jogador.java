/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia;

import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.MercadoriaTotal;
import java.util.Set;

/**
 *
 * @author IzabelyFurtado
 */
public class Jogador {
    String nome;
    int ouro;
    //mercadorias arrecadadas
    MercadoriaTotal arrecadadas;
    //mercadorias a mão
    Set<Mercadoria> cartas;
    
}
