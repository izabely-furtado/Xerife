/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.jogadores;

import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.MercadoriaTotal;
import ifes.trabia.mercadoria.Tipo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IzabelyFurtado
 */
public class Jogador {
    String nome;
    public int ouro;
    //mercadorias arrecadadas
    public MercadoriaTotal arrecadadas;
    //mercadorias a mão
    public Mercadoria[] emMaos;
    public List<Mercadoria> emMaosVizualizada;
    public float confianca;
    public Tipo tipo;
    
    @Override
    public String toString(){
        return this.nome + " - Tipo: " + this.tipo + " - Ouro: " + this.ouro + "Confianca: " + this.confianca +
               " - Em mãos: \n" + this.toStringEmMaos() + "Vizualizada: \n" + this.toStringVizu();
    }
    
    public String toStringEmMaos(){
        String retorno = "";
        for (Mercadoria m : this.emMaos){
            retorno += m.toString() + "\n";
        }
        return retorno;
    }

    public String toStringVizu(){
        String retorno = "";
        for (Mercadoria m : this.emMaosVizualizada){
            retorno += m.toString() + "\n";
        }
        return retorno;
    }

    Jogador(String nome){
        this.nome = nome;
        this.arrecadadas = new MercadoriaTotal(1);
        this.ouro = 50;
        this.emMaos = new Mercadoria[6];
        this.emMaosVizualizada = new ArrayList();
        this.confianca = 100;
    }
    
    public void arrecada(Tipo identificador){
        this.arrecadadas.getMercadoria(identificador).quantCartas++;
    }
    
    public void colocaEmMaos(Mercadoria[] mercadorias){
        this.emMaos = mercadorias;
    }
    
    public void ganhaOuro(int quanto){
        this.ouro += quanto;
    }
    
    //entra com a mercadoria que vai ser trocado por this.emMaos[indice]
    public Mercadoria troca(Mercadoria merc, int indice){
        Mercadoria original = this.emMaos[indice];
        this.emMaos[indice] = merc;
        return original;
    }
    
    //entra com a mercadoria que vai ser trocado por this.emMaos[indice]
    public Mercadoria troca(Mercadoria merc, Mercadoria mercNova){
        for (int m = 0; m < this.emMaos.length; m++){
            if (this.emMaos[m] == merc){
                this.emMaos[m] = mercNova;
                return merc;
            }
        }
        return merc;
    }
    
    //jogando por alto a quantidade de partidas total seria 10
    public void mentiu(){
        this.confianca -= 1/10;
    }

    public int perdeOuro(int penalidade) {
        if (penalidade <= ouro){
            this.ouro -= penalidade;
            return penalidade;
        }
        else {
            int antes = this.ouro;
            this.ouro = 0;
            return antes;
        }
    }
    
    
    
}
