/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.trabia.mercadoria;

/**
 *
 * @author IzabelyFurtado
 */
public class Mercadoria1{
    //sendo referente as quantidades
    private final int valor;
    private final int penalidade;
    public int quantCartas;
    private final Tipo tipo;
    private final Tipo id;
    
    private Mercadoria1 (int valor, int penalidade, Tipo tipo, Tipo identificador) {
        this.valor = valor;
        this.penalidade = penalidade;
        this.tipo = tipo;
        this.id = identificador;
    }
      
    public int getValor(){
        return this.valor;
    }
    
    public int getPenalidade(){
        return this.penalidade;
    }
    
    public Tipo getTipo(){
        return this.tipo;
    }
    
    public static Mercadoria1 criaMaca(int quantJogadores) {
        return new Mercadoria1 (2, 2, Tipo.Legal, Tipo.maca);
    }
    
    public static Mercadoria1 criaQueijo(int quantJogadores) {
        return new Mercadoria1 (3, 2, Tipo.Legal, Tipo.queijo);
    }
    
    public static Mercadoria1 criaPao(int quantJogadores) {
        return new Mercadoria1 (3, 2, Tipo.Legal, Tipo.pao);
    }
    
    public static Mercadoria1 criaGalinha(int quantJogadores) {
        return new Mercadoria1 (4, 2, Tipo.Legal, Tipo.galinha);
    }
        
    public static Mercadoria1 criaPimenta(int quantJogadores) {
        return new Mercadoria1 (6, 4, Tipo.Contrabando, Tipo.pimenta);
    }
    
    public static Mercadoria1 criaHidroMel(int quantJogadores) {
        return new Mercadoria1 (7, 4, Tipo.Contrabando, Tipo.hidroMel);
    }

    public static Mercadoria1 criaTecido(int quantJogadores) {
        return new Mercadoria1 (8, 4, Tipo.Contrabando, Tipo.tecido);
    }

    public static Mercadoria1 criaBesta(int quantJogadores) {
        return new Mercadoria1 (9, 4, Tipo.Contrabando, Tipo.besta);
    }

    public static Mercadoria1 criaMacaVerde(int quantJogadores) {
        return new Mercadoria1 (4, 3, Tipo.Real, Tipo.macaVerde);
    }

    public static Mercadoria1 criaMaçaDourada(int quantJogadores) {
        return new Mercadoria1 (6, 4, Tipo.Real, Tipo.macaDourada);
    }
    
    public static Mercadoria1 criaQueijoGouda(int quantJogadores) {
        return new Mercadoria1 (6, 4, Tipo.Real, Tipo.queijoGouda);
    }

    public static Mercadoria1 criaQueijoAzul(int quantJogadores) {
        return new Mercadoria1 (9, 5, Tipo.Real, Tipo.queijoAzul);
    }

    public static Mercadoria1 criaPaoCenteio(int quantJogadores) {
        return new Mercadoria1 (6, 4, Tipo.Real, Tipo.paoCenteio);
    }

    public static Mercadoria1 criaPaoCenteioIntegral(int quantJogadores) {
        return new Mercadoria1 (9, 5, Tipo.Real, Tipo.paoCenteioIntegral);
    }

    public static Mercadoria1 criaGaloReal(int quantJogadores) {
        return new Mercadoria1 (8, 4, Tipo.Real, Tipo.galoReal);
    }
    
}
