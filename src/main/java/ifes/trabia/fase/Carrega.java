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
 * Fase 2: Carregar Merchant Bag
    Coloque as cartas que pretende levar ao mercado na bolsa de comerciante.
    - Colocar a partir de um a cinco produtos.
 
 */
public class Carrega {
    
    public static List<Mercadoria>[] carregaBags(Jogador[] jogadores){
        List<Mercadoria>[] retorno = new List[jogadores.length];
        for (int j = 0; j < jogadores.length; j++) {
            switch (jogadores[j].tipo){
                case Verdadeiro:
                    retorno[j] = Carrega.carregaBagLegal(jogadores[j]);
                case Contrabandista:
                    retorno[j] = Carrega.carregaContrabando(jogadores[j]);
                case Aleatorio:
                    retorno[j] = Carrega.carregaBag(jogadores[j]);
            }
        }
        return retorno;
    }
    //retorna as mercadorias legais na mao do jogador
    public static List<Mercadoria> legais(Jogador jogador){
        List<Mercadoria> retorno = new ArrayList();
        for (Mercadoria m : jogador.emMaos){
            if (m.getTipo()==Tipo.Legal){
                retorno.add(m);
            }
        }
        return retorno;
    }
    
    //retorna as mercadorias ilegais na mao do jogador
    public static List<Mercadoria> ilegais(Jogador jogador){
        List<Mercadoria> retorno = new ArrayList();
        for (Mercadoria m : jogador.emMaos){
            if (!(m.getTipo()==Tipo.Legal)){
                retorno.add(m);
            }
        }
        return retorno;
    }
    
    //retorna de uma  5 mercadorias aleatorias
    public static List<Mercadoria> carregaBag(Jogador jogador) {
        List<Mercadoria> entregar = new ArrayList();
        Random gerador = new Random();
        boolean insereBag;
        //insere nos bags (imaginario e real)
        for (Mercadoria m : jogador.emMaos){
            insereBag = gerador.nextBoolean();
            //se decide inserir, 
                //só insere se for legal e nao tiver ultrapassado 5 inseridos
            if (insereBag == true && entregar.size() <= 5){
                entregar.add(m);
            }
        }
        //verifica se pelo ou menos 1 foi colocado no bag
        //se nenhum foi, um aleatorio é escolhido
        if (entregar.isEmpty()){
            entregar.add(jogador.emMaos[gerador.nextInt(5)]);
        }
        return entregar;
    }
    
    //retorna de uma a 5 mercadorias legais
    public static List<Mercadoria> carregaBagLegal(Jogador jogador) {
        List<Mercadoria> entregar = new ArrayList();
        List<Mercadoria> legais = Carrega.legais(jogador);
        Random gerador = new Random();
        boolean insereBag;
        //insere nos bags (imaginario e real)
        for (Mercadoria m : legais){
            insereBag = gerador.nextBoolean();
            //se decide inserir, 
                //só insere se for legal e nao tiver ultrapassado 5 inseridos
            if (insereBag == true && entregar.size() <= 5){
                entregar.add(m);
            }
        }
        //verifica se pelo ou menos 1 foi colocado no bag
        //se nenhum foi, um aleatorio é escolhido
        if (entregar.isEmpty()){
            //se nao tiver mercadorias legais
            // dos males o menor, só adiciona uma mercadoria
            if (legais.isEmpty()){
                entregar.add(jogador.emMaos[gerador.nextInt(jogador.emMaos.length - 1)]);
            }
            else {
                entregar.add(legais.get(gerador.nextInt(5)));
            }
        }
        return entregar;
    }
    
    //retorna de uma a 5 mercadorias legais
    public static List<Mercadoria> carregaContrabando(Jogador jogador) {
        List<Mercadoria> entregar = new ArrayList();
        List<Mercadoria> ilegais = Carrega.ilegais(jogador);
        Random gerador = new Random();
        boolean insereBag;
        //insere nos bags (imaginario e real)
        for (Mercadoria m : ilegais){
            insereBag = gerador.nextBoolean();
            //se decide inserir, 
                //só insere se for legal e nao tiver ultrapassado 5 inseridos
            if (insereBag == true && entregar.size() <= 5){
                entregar.add(m);
            }
        }
        //verifica se pelo ou menos 1 foi colocado no bag
        //se nenhum foi, um aleatorio é escolhido
        if (entregar.isEmpty()){
            //se nao tiver mercadorias ilegais
            // dos males o menor, só adiciona uma mercadoria
            if (ilegais.isEmpty()){
                entregar.add(jogador.emMaos[gerador.nextInt(jogador.emMaos.length - 1)]);
            }
            else {
                entregar.add(ilegais.get(gerador.nextInt(5)));
            }
        }
        return entregar;
    }
    
    
}
