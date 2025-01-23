package br.com.exemplo.bridge.formas;

import br.com.exemplo.bridge.cores.Cor;

//Abstração Refinada para um Círculo
public class Circulo extends Forma {
 public Circulo(Cor cor) {
     super(cor);
 }

 @Override
 public void desenhar() {
     System.out.print("Desenhando um círculo com ");
     cor.aplicarCor();
 }
}