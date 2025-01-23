package br.com.exemplo.bridge.formas;

import br.com.exemplo.bridge.cores.Cor;

//Abstração Refinada para um Quadrado
public class Quadrado extends Forma {
 public Quadrado(Cor cor) {
     super(cor);
 }

 @Override
 public void desenhar() {
     System.out.print("Desenhando um quadrado com ");
     cor.aplicarCor();
 }
}
