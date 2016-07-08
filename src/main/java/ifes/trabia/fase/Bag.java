/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.Jogador;
import ifes.trabia.Xerife;
import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.MercadoriaTotal;
import ifes.trabia.mercadoria.Tipo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author IzabelyFurtado
 */
public class Bag {
    Jogador jogador;
    List<Mercadoria> dizQueEntregou;
    List<Mercadoria> entregou;
    Xerife xerife;
    
    Bag(Jogador jogador, List<Mercadoria> dizQue, List<Mercadoria> entregou, Xerife xerife){
        this.jogador = jogador;
        this.xerife = xerife;
        if (dizQue.size()==entregou.size()){
            this.entregou = entregou;
            for (Mercadoria m: dizQue){
                if (m.getTipo()!=Tipo.Legal){
                    throw new RuntimeException("tens probleminha?");
                }
            }
            this.dizQueEntregou = dizQue;
        }
        else {
            throw new RuntimeException("tens probleminha?");
        }
    }
    
    Bag(Jogador jogador, Xerife xerife){
        this.jogador = jogador;
        this.xerife = xerife;
        Random gerador = new Random();
        MercadoriaTotal mT = new MercadoriaTotal(1);
        Tipo[] vetTipo = {Tipo.maca, Tipo.queijo, Tipo.pao, Tipo.galinha};
        int qualMentira, carta;
        boolean insereBag, contaVDD;
        //insere nos bags (imaginario e real)
        for (Mercadoria m : this.jogador.emMaos){
            insereBag = gerador.nextBoolean();
            contaVDD  = gerador.nextBoolean();
            if (insereBag == true){
                this.entregou.add(m);
                //se decidiu contar a vdd e o tipo é legalizado p/ comercio
                if (contaVDD == true && m.getTipo()==Tipo.Legal){
                    this.dizQueEntregou.add(m);
                }
                else{
                    this.dizQueEntregou.add(mT.getMercadoria(vetTipo[gerador.nextInt(3)]));
                }
            }
        }
        //verifica se pelo ou menos 1 foi colocado no bag
        if (this.entregou.isEmpty()){
            Mercadoria m = this.jogador.emMaos[gerador.nextInt(5)];
            this.entregou.add(m);
            contaVDD  = gerador.nextBoolean();
            if (contaVDD == true && m.getTipo()==Tipo.Legal){
                this.dizQueEntregou.add(m);
            }
            else {
                this.dizQueEntregou.add(mT.getMercadoria(vetTipo[gerador.nextInt(3)]));
            }
        }
        //verifica se foi colocado mais que 5...caso true.. remove de ambos
        if (this.entregou.size()>5){
            this.dizQueEntregou.remove(this.entregou.remove(gerador.nextInt(5)));
        }
    }

    public List<Mercadoria> diferenca(){
        List<Mercadoria> dif = new ArrayList();
        
        if (this.dizQueEntregou.containsAll(entregou)){
            return dif;
        }
        else{
            for (Mercadoria m: this.entregou){
                if (!this.dizQueEntregou.contains(m)){
                    dif.add(m);
                }
            }
            return dif;
        }
    }
    
    public List<Mercadoria> igualdade(){
        List<Mercadoria> dif = new ArrayList();
        
        if (this.dizQueEntregou.containsAll(entregou)){
            return dif;
        }
        else{
            for (Mercadoria m: this.entregou){
                if (this.dizQueEntregou.contains(m)){
                    dif.add(m);
                }
            }
            return dif;
        }
    }
    
/*
    a diferença entre o que disse ser e o que era
    considerando que a quantidade media de partidas que terá será 10 
        e uma margem de erro de 10%
    e considerando a quantidade entregue de cartas 
        ja que pode entregar de 1 a 5 cartas
    quantasMentiu/quantasentregou
*/
    public float mudaConfianca(){
        List<Mercadoria> diferenca = this.diferenca();
        float retorno = 0;
        int maFe = 0;
        if (diferenca.isEmpty()){
            return 1/9 ;
        }
        else {
            retorno -= 1/9*diferenca().size()/this.entregou.size();
            for (Mercadoria m: diferenca){
                if (m.getTipo()!=Tipo.Legal){
                    maFe++; 
                }
            }
            retorno *= (1.1 + maFe)/this.entregou.size(); //punicao por má fé
            return retorno;
        }
    }
    
    //o jogador ja é atualizado com 
        //as mercadorias do bag e 
        //a confiança
    public void seXerifeConfiou(){
        for (Mercadoria merc: this.entregou){
            this.jogador.arrecada(merc.id);
        }
        this.jogador.confianca += this.mudaConfianca();
    }
    
    //o jogador ja é atualizado com 
        //as mercadorias do bag que ele disse que tinha
        //e a confiança
    //o xerife ja é penalizado ou bonificado
    public void seXerifeNConfiou(){
        if (this.diferenca().isEmpty()){
            for (Mercadoria merc: this.entregou){
                this.jogador.arrecada(merc.id);
                this.jogador.ganhaOuro(merc.getPenalidade());
                this.xerife.paga(merc.getPenalidade());
            }
        }
        else {
            for (Mercadoria merc: this.igualdade()){
                this.jogador.arrecada(merc.id);
            }
            for (Mercadoria merc: this.diferenca()){
                this.xerife.recebe(this.jogador.perdeOuro(merc.getPenalidade()));
                this.xerife.arrecada(merc.id);
            }
        }
        this.jogador.confianca += this.mudaConfianca();
    }
}

