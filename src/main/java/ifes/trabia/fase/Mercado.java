/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.fase;

import ifes.trabia.Jogador;
import ifes.trabia.Jogo;
import ifes.trabia.mercadoria.Mercadoria;
import ifes.trabia.mercadoria.Tipo;
import java.util.Random;

/**
 *
 * @author IzabelyFurtado
 *
    Fase 1: Mercado
Você pode descartar cartas indesejadas e comprar novas.
- Vá em sentido horário começando a esquerda do xerife.
- Separe até cinco cartas.
- compre de uma das 3 pilhas. 
    - se vc comecar a comprar da pilha de compra escondida, vc deve continuar comprando de la,
    - mas pra comprar da pilha de descarte, vc deve pegar na ordem da pilha...
- Descarte suas cartas separadas na pilha de descarte desejada.
    - [somente temos duas pilhas de descarte, e ambas comecam com 5 cartas viradas pra cima no comeco do jogo]
*/
   
public class Mercado {

    private Jogo jogo;
    
    Mercado (Jogo jogo){
        this.jogo = jogo;
        Random gerador = new Random();
        int resultado, resultado2;
        //pode desejar trocar 0 até 5 cartas
        Mercadoria[] cartasParaTrocar = new Mercadoria[5];
        //em sentido horario
        for (Jogador j: this.jogo.Jogadores){
            //quantas cartas vai descartar
            resultado = gerador.nextInt(5);
            for (int quant = 0; quant < resultado; quant++){
                resultado2 = gerador.nextInt(resultado -1);
                //faz a troca e descarta
                j = this.houveTroca(j, resultado2, this.jogo.baralho.
                        setDescarte(j.troca(this.jogo.baralho.getBaralho(), resultado2)));
            }
        }
    }
    
    public Jogador houveTroca(Jogador j, int indiceMercadoriaOriginal, Tipo devolucao){
        Mercadoria adquirida, original;
        switch(devolucao){
            case descarte1:
                //descarto do 1 
                adquirida = this.jogo.baralho.getDescarte1();
                //considero essa mercadoria como ja vizualizada pelo xerife
                j.emMaosVizualizada.add(adquirida);
                //faço a troca de cartas
                original = j.troca(adquirida, indiceMercadoriaOriginal);
                j.confianca += this.mudaConfianca(original, adquirida);
                
            case descarte2:
                //descarto do 2
                adquirida = this.jogo.baralho.getDescarte2();
                //considero essa mercadoria como ja vizualizada pelo xerife
                j.emMaosVizualizada.add(adquirida);
                //faço a troca de cartas
                original = j.troca(adquirida, indiceMercadoriaOriginal);
                j.confianca += this.mudaConfianca(original, adquirida);
             
            case baralho:
                //descarto do baralho sem guardar qual é a carta
                //faço a troca de cartas
                original = j.troca(this.jogo.baralho.getBaralho(), indiceMercadoriaOriginal);
                j.confianca += this.mudaConfianca(original);
        }
        return j;
    }
    
/*
    São 6 cartas em mãos dos jogadores
    Cada carta pode ser Legal, Contrabando ou Real
    Ou seja... Legal ou Ilegal
        (total de cartas legais)/(total de cartas) de uma carta ser legal
        (total de cartas ilegais/(total de cartas) de uma carta ser ilegal
    considerando uma margem de erro de 10/total de cartas já que 10 cartas foram tiradas
    
    caso esteja num jogo com 3 pessoas
        108/162 de uma carta ser legal
        54/162  de uma carta ser ilegal
    considerando uma margem de erro de 0,0666667 --> 10/162 já que 10 cartas foram tiradas
    
    caso esteja num jogo com 4 ou 5 pessoas
        144/216 de uma carta ser legal
        72/216  de uma carta ser ilegal
    considerando uma margem de erro de 0,046296 --> 10/216 já que 10 cartas foram tiradas
*/
    public float mudaConfianca(Mercadoria original){
        //se está trocando a ctz de ser legal por uma incerteza
        //vai ter que aguentar um nivel de desconfiança considerando que 
        //dispensou a ctz de ter uma mercadoria legal e 
        //aceitou a possibilidade de ser ilegal 
        //só a chance de ser ilegal será contabilizada
        //MUARARARRARARARA :D
        //analogamente para ser ilegal O:)
        switch(this.jogo.quantJogadores){
            case 3:
                if (original.getTipo()==Tipo.Legal){
                    return -54/162 +10/162; 
                }
                else {
                    return +108/162 -10/162;
                }
            case 4:
            case 5:
                if (original.getTipo()==Tipo.Legal){
                    return -72/216 +10/216; 
                }
                else {
                    return +144/216 -10/216;
                }
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
    
/*  
    apostando em cartas certeiras e vizualizaveis
    da a ctz que ele tirou uma carta legal ou ilegal
    assim ele tem 1/6 cartas com essa caracteristica
    além disso considero duas possibilidades
        se o jogador mentir sobre a carta
        se dizer a vdd
    mas se for ilegal... só tem a possibilidade de mentir sobre a carta
*/
    public float mudaConfianca(Mercadoria original, Mercadoria atual){
        float retorno = this.mudaConfianca(original);
        if (original.getTipo()==Tipo.Legal){
            return retorno += 1/6 * 1/2; 
        }
        else {
            return retorno -= 1/6;
        }
    }
    
}

