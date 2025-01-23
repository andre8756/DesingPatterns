package br.com.exemplo.bridge;
import br.com.exemplo.bridge.cores.Azul;
import br.com.exemplo.bridge.cores.Vermelho;
import br.com.exemplo.bridge.formas.Circulo;
import br.com.exemplo.bridge.formas.Forma;
import br.com.exemplo.bridge.formas.Quadrado;

public class Main {
    public static void main(String[] args) {
        Forma circuloVermelho = new Circulo(new Vermelho());
        circuloVermelho.desenhar();

        Forma quadradoAzul = new Quadrado(new Azul());
        quadradoAzul.desenhar();
    }
}
