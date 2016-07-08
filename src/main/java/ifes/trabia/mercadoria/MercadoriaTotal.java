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
public class MercadoriaTotal{
    Mercadoria maca;
    Mercadoria queijo;
    Mercadoria pao;
    Mercadoria galinha;
    Mercadoria pimenta;
    Mercadoria hidroMel;
    Mercadoria tecido;
    Mercadoria besta;
    Mercadoria macaVerde;
    Mercadoria macaDourada;
    Mercadoria queijoGouda;
    Mercadoria queijoAzul;
    Mercadoria paoCenteio;
    Mercadoria paoCenteioIntegral;
    Mercadoria galoReal;
    int total;
    
    public MercadoriaTotal (int quantJogadores) {
        this.maca = Mercadoria.criaMaca(quantJogadores) ;
        this.queijo = Mercadoria.criaQueijo(quantJogadores);
        this.pao = Mercadoria.criaPao(quantJogadores);
        this.galinha = Mercadoria.criaGalinha(quantJogadores);
        this.pimenta = Mercadoria.criaPimenta(quantJogadores);
        this.hidroMel = Mercadoria.criaHidroMel(quantJogadores);
        this.tecido = Mercadoria.criaTecido(quantJogadores);
        this.besta = Mercadoria.criaBesta(quantJogadores);
        this.macaVerde = Mercadoria.criaMacaVerde(quantJogadores);
        this.macaDourada = Mercadoria.criaMaçaDourada(quantJogadores);
        this.queijoGouda = Mercadoria.criaQueijoGouda(quantJogadores);
        this.queijoAzul = Mercadoria.criaQueijoAzul(quantJogadores);
        this.paoCenteio = Mercadoria.criaPaoCenteio(quantJogadores);
        this.paoCenteioIntegral = Mercadoria.criaPaoCenteioIntegral(quantJogadores);
        this.galoReal = Mercadoria.criaGaloReal(quantJogadores);
        switch (quantJogadores) {
            case 1:
                this.total = 0;
            case 3:
                this.total = 162 - 10;
            case 4:
            case 5:
                this.total = 216 - 10;
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
      
    public Mercadoria getMercadoria(Tipo tipo){
        switch (tipo) {
            case maca:
                return this.maca;
            case queijo:
                return this.queijo;
            case pao:
                return this.pao;
            case galinha:
                return this.galinha;
            case pimenta:
                return this.pimenta;
            case hidroMel:
                return this.hidroMel;
            case tecido:
                return this.tecido;
            case besta:
                return this.besta;
            case macaVerde:
                return this.macaVerde;
            case macaDourada:
                return this.macaDourada;
            case queijoGouda:
                return this.queijoGouda;
            case queijoAzul:
                return this.queijoAzul;
            case paoCenteio:
                return this.paoCenteio;
            case paoCenteioIntegral:
                return this.paoCenteioIntegral;
            case galoReal:
                return this.galoReal;
            default:
                throw new RuntimeException("Quantidade de jogadores não suportada");
        }
    }
    
}