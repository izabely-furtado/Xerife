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
public class Mercadoria{
    //sendo referente as quantidades
    private final int valor;
    private final int penalidade;
    public int quantCartas;
    private final Tipo tipo;
    private final Tipo id;
    
    private Mercadoria (int quantCartas, int valor, int penalidade, Tipo tipo, Tipo identificador) {
        this.valor = valor;
        this.penalidade = penalidade;
        this.tipo = tipo;
        this.quantCartas = quantCartas;
        this.id = identificador;
    }
      
    public int getValor(){
        return this.valor;
    }
    
    public void unaCarta(){
        this.quantCartas = 1;
    }
    
    public int getPenalidade(){
        return this.penalidade;
    }
    
    public Tipo getTipo(){
        return this.tipo;
    }
    
    public static Mercadoria criaMaca(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 2, 2, Tipo.Legal, Tipo.maca);
            case 3:
            case 4:
            case 5:
                return new Mercadoria (48, 2, 2, Tipo.Legal, Tipo.maca);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
                
    }
    
    public static Mercadoria criaQueijo(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 3, 2, Tipo.Legal, Tipo.queijo);
            case 3:
            case 4:
            case 5:
                return new Mercadoria (36, 3, 2, Tipo.Legal, Tipo.queijo);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
    
    public static Mercadoria criaPao(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 3, 2, Tipo.Legal, Tipo.pao);
            case 3:
                return new Mercadoria (0, 3, 2, Tipo.Legal, Tipo.pao);
            case 4:
            case 5:
                return new Mercadoria (36, 3, 2, Tipo.Legal, Tipo.pao);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
    
    public static Mercadoria criaGalinha(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 4, 2, Tipo.Legal, Tipo.galinha);
            case 3:
            case 4:
            case 5:
                return new Mercadoria (24, 4, 2, Tipo.Legal, Tipo.galinha);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
        
    public static Mercadoria criaPimenta(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 6, 4, Tipo.Contrabando, Tipo.pimenta);
            case 3:
                return new Mercadoria (18, 6, 4, Tipo.Contrabando, Tipo.pimenta);
            case 4:
            case 5:
                return new Mercadoria (22, 6, 4, Tipo.Contrabando, Tipo.pimenta);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
    
    public static Mercadoria criaHidroMel(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 7, 4, Tipo.Contrabando, Tipo.hidroMel);
            case 3:
                return new Mercadoria (16, 7, 4, Tipo.Contrabando, Tipo.hidroMel);
            case 4:
            case 5:
                return new Mercadoria (21, 7, 4, Tipo.Contrabando, Tipo.hidroMel);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaTecido(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 8, 4, Tipo.Contrabando, Tipo.tecido);
            case 3:
                return new Mercadoria (9, 8, 4, Tipo.Contrabando, Tipo.tecido);
            case 4:
            case 5:
                return new Mercadoria (12, 8, 4, Tipo.Contrabando, Tipo.tecido);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaBesta(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 9, 4, Tipo.Contrabando, Tipo.besta);
            case 3:
            case 4:
            case 5:
                return new Mercadoria (5, 9, 4, Tipo.Contrabando, Tipo.besta);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaMacaVerde(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 4, 3, Tipo.Real, Tipo.macaVerde);
            case 3:
            case 4:
            case 5:
                return new Mercadoria (2, 4, 3, Tipo.Real, Tipo.macaVerde);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaMaçaDourada(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 6, 4, Tipo.Real, Tipo.macaDourada);
            case 3:
                return new Mercadoria (1, 6, 4, Tipo.Real, Tipo.macaDourada);
            case 4:
            case 5:
                return new Mercadoria (2, 6, 4, Tipo.Real, Tipo.macaDourada);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaQueijoGouda(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 6, 4, Tipo.Real, Tipo.queijoGouda);
            case 3:
            case 4:
            case 5:
                return new Mercadoria (2, 6, 4, Tipo.Real, Tipo.queijoGouda);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaQueijoAzul(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
            case 3:
                return new Mercadoria (0, 9, 5, Tipo.Real, Tipo.queijoAzul);
            case 4:
            case 5:
                return new Mercadoria (1, 9, 5, Tipo.Real, Tipo.queijoAzul);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaPaoCenteio(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
            case 3:
                return new Mercadoria (0, 6, 4, Tipo.Real, Tipo.paoCenteio);
            case 4:
            case 5:
                return new Mercadoria (2, 6, 4, Tipo.Real, Tipo.paoCenteio);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaPaoCenteioIntegral(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
            case 3:
                return new Mercadoria (0, 9, 5, Tipo.Real, Tipo.paoCenteioIntegral);
            case 4:
            case 5:
                return new Mercadoria (1, 9, 5, Tipo.Real, Tipo.paoCenteioIntegral);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }

    public static Mercadoria criaGaloReal(int quantJogadores) {
        switch (quantJogadores) {
            case 1: 
                return new Mercadoria (0, 8, 4, Tipo.Real, Tipo.galoReal);
            case 3:
                return new Mercadoria (1, 8, 4, Tipo.Real, Tipo.galoReal);
            case 4:
            case 5:
                return new Mercadoria (2, 8, 4, Tipo.Real, Tipo.galoReal);
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
    
    
}
